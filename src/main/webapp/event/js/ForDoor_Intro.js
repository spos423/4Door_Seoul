let introDiv = document.querySelector('.intro');
let dongdaemunDiv = document.querySelector('.dongdaemun');
let seodaemunDiv = document.querySelector('.seodaemun');
let namdaemunDiv = document.querySelector('.namdaemun');
let bukdaemunDiv = document.querySelector('.bukdaemun');

window.addEventListener('scroll', function(){
    let value = this.window.scrollY;

    console.log("scrollY", value);

    if(value>600 && value<1500) {
    	introDiv.style.animation="animate-in 1s ease-out forwards";
    }else {
    	introDiv.style.animation="animate-out 1s ease-out forwards";
    }
   
    if(value>1700 && value<2700) {
    	dongdaemunDiv.style.animation="animate-in 1s ease-out forwards";
    }else {
    	dongdaemunDiv.style.animation="animate-out 1s ease-out forwards";
    }    
    
	if(value>3500 && value<4500) {
		seodaemunDiv.style.animation="animate-in 1s ease-out forwards";
	}else {
		seodaemunDiv.style.animation="animate-out 1s ease-out forwards";
	}
	
	if(value>5100 && value<6400){
		namdaemunDiv.style.animation="animate-in 1s ease-out forwards";
	}else{
		namdaemunDiv.style.animation="animate-out 1s ease-out forwards";
	}
	
	if(value>7200 && value<8200) {
		bukdaemunDiv.style.animation="animate-in 1s ease-out forwards";
	}else {
		bukdaemunDiv.style.animation="animate-out 1s ease-out forwards";
	}
	
});

