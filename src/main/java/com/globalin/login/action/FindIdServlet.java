package com.globalin.login.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FindIdServlet")
public class FindIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String email = request.getParameter("email");

        String dbUrl = "jdbc:oracle:thin:@localhost:1521:your_database";
        String dbUser = "your_db_user";
        String dbPassword = "your_db_password";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);

            String query = "SELECT id FROM users WHERE name=? AND email=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String userId = resultSet.getString("id");
                request.setAttribute("userId", userId);
                request.getRequestDispatcher("findIdResult.jsp").forward(request, response);
            } else {
                out.println("일치하는 사용자를 찾을 수 없습니다.");
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
