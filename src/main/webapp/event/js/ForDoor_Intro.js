let introDiv = document.querySelector('.intro');
let dongdaemunDiv = document.querySelector('.dongdaemun');

// opacity : 0 주는 이벤트리스너
window.addEventListener('scroll', function(){
    let value = this.window.scrollY;

    console.log("scrollY", value);

    if(value>600) {
    	introDiv.style.animation="animate-in 1s ease-out forwards";
    }
    if(value>2208) {
    	dongdaemunDiv.style.animation="animate-in 1s ease-out forwards";
    }

});


// opacity : 1 주는 이벤트리스너
window.addEventListener('scroll', function(){
    let value = this.window.scrollY;

    console.log("scrollY", value);

    if(value>1500) {
        introDiv.style.animation="animate-out 1s ease-out forwards";
    }
    if(value>3400) {
        dongdaemunDiv.style.animation="animate-out 1s ease-out forwards";
    }
});