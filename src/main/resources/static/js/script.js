// main
const swiper = new Swiper('.swiper', {
    loop: true,
    autoplay: { delay: 2000 },
    speed: 500
});

// user/email
function $ComTimer(){
    //prototype extend
}

$ComTimer.prototype = {
    comSecond : ""
    , fnCallback : function(){}
    , timer : ""
    , domId : ""
    , fnTimer : function(){
        var m = Math.floor(this.comSecond / 60) + "분 " + (this.comSecond % 60) + "초";	// 남은 시간 계산
        this.comSecond--;					// 1초씩 감소
        console.log(m);
        this.domId.innerText = m;
        if (this.comSecond < 0) {			// 시간이 종료 되었으면..
            clearInterval(this.timer);		// 타이머 해제
            alert("인증시간이 초과하였습니다. 다시 인증해주시기 바랍니다.")
        }
    }
    ,fnStop : function(){
        clearInterval(this.timer);
    }
}


const sendEmail = document.getElementById("sendEmail");
sendEmail.addEventListener("click", function() {
    sendEmail.innerText = "인증번호 확인";
    var AuthTimer = new $ComTimer()
    AuthTimer.comSecond = 180;
    AuthTimer.fnCallback = function(){alert("다시인증을 시도해주세요.")}
    AuthTimer.timer =  setInterval(function(){AuthTimer.fnTimer()},1000);
    AuthTimer.domId = document.getElementById("timer");
});

if (sendEmail.innerText === "인증번호 보내기") {
    document.getElementById("timer").style.display = 'none';
} else {
    document.getElementById("timer").style.display = 'block';
}

// recipe/recipe
const addPlus = document.getElementById("addPlus");
addPlus.addEventListener("click", function() {            
    
});
const a = document.getElementsByClassName("recipe-category__select");
if (a.length == 3) {
    addPlus.style.display = 'none';
} else if (a.length == 1) {
    document.querySelector('.btn--delete').style.display = 'none';
} else {
    addPlus.style.display = 'block';
}