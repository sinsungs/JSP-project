<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이쇼핑몰(KDH17) - 맥주자료입력(C)</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
function idCheck() {
	var userID = $('#u_id').val();
	$.ajax({
		type: 'POST',
		url:'./idCheck.jsp',
		data:{ userID : userID }  // { 파라미터 변수이름 : 값 }
		success: function(result) {
			if(res==0){
	               $(".idIsFalse").show();
	               $(".idIsTrue").hide();
	            }else{
	               $(".idIsFalse").hide();
	               $(".idIsTrue").show();
	            }
		},
		error:function(request,status,error){
            console.log(error);
         }
	});
}
</script>
</head>
<body>

<%@ include file="/header.jsp" %>

<div class="content">
<form method="post" action="./insertUser.be" style="width:350px; margin-left: auto; margin-right: auto;">

	<br>이름 : <input type="text" name="u_name" size="30">
	<br>아이디 : <input type="text" name="u_id" id="u_id" size="30">
	<button onclick="idCheck();" type="button">중복체크</button>
	 <span style="color:red; display:none;" class="idIsFalse">사용 중인 아이디입니다.</span>
     <span style="color:green; display:none;" class="idIsTrue">사용 가능한 아이디입니다.</span>
     <br>
	<br>비밀번호 : <input type="text" name="u_pw" size="30">
	<br>이메일 : <input type="text" name="u_mail" size="30">
	<br>전화번호 : <input type="text" name="u_phone" size="30">
	<br>주민번호 : <input type="text" name="u_rrn" size="30">
	<br><input type="hidden" name="actionType" value="C">
	<button type="submit"><a>회원가입</a></button>
</form>

   
<!--    <form name="join" method="post" action="/member01/mem_models/member_dao.jsp">
      <div>
            <label for = "name"> <strong>이름</strong></label>
            <input type="text" name="name" />
            <label for = "id"> <strong>아이디</strong></label>
            <input type="text" name="id"> 
               <span style="color:red; display:none;" class="idIsFalse">사용 중인 아이디입니다.</span>
               <span style="color:green; display:none;" class="idIsTrue">사용 가능한 아이디입니다.</span>
               <br>
            <label for = "password"> <strong>비밀번호</strong></label>
            <input type="password" name="passwd">         
            <label for = "email"> <strong>이메일</strong></label>   
            <input type="email" name="email">
            <label for = "phone"> <strong>전화번호</strong></label>
            <input type="text" name="phone"/>
            <label for = "rrn"> <strong>주민번호</strong></label>
            <input id="userRRN" type="text" name="rrn"><button type="button" class="btn btn-success" onclick="RRNCheck()" style="background:#7369AB; color:white">주민번호 유효성 체크</button> <span id="RRNresult"></span>
            <input type="hidden" name="actionType" value="JOIN" >
            <br> <br>
            <input class="btn btn-primary btn-lg" type="submit" value="회원가입" style="        margin:auto;
        display:block;">
            <input class="submitBtn" type="submit" value="회원가입">
       
      
   </form>
    -->
</div>

</body>
<script>
	function idCheck() {
		var userID = $('#u_id').val();
		$.ajax({
			type: 'POST',
			url:'./idCheck.jsp',
			data:{ userID : userID }  // { 파라미터 변수이름 : 값 }
			success: function(result) {
				if(res==0){
		               $(".idIsFalse").show();
		               $(".idIsTrue").hide();
		            }else{
		               $(".idIsFalse").hide();
		               $(".idIsTrue").show();
		            }
			},
			error:function(request,status,error){
	            console.log(error);
	         }
		});
	}

</script>
<!-- <script>
   $(function (){
      $(".idIsFalse .idIsTrue").hide();
   });
   $("input[name='u_id']").on("keyup keypress", function (e){
      let mem_id = $(this).val();
      $.ajax({
         url:"./idChk.jsp",
         type:"post",
         data:{userID:mem_id},
         success : function(res){
            res = res.replace(/\s/gi, "");
            
            if(res==0){
               $(".idIsFalse").show();
               $(".idIsTrue").hide();
            }else{
               $(".idIsFalse").hide();
               $(".idIsTrue").show();
            }
                        
         },
         error:function(request,status,error){
            console.log(error);
         }
      });
   });
</script> -->
<script>
       
        function RRNCheck() { // 주민등록번호 유효성검사 메소드
           var rrn = $("#userRRN").val().replace('-','');//폼의 rrnNum값 가져오기
            rrn = rrn.split(''); // 주민등록번호를 한자리씩 쪼개서 배열에 담기
            var ckarr = [2,3,4,5,6,7,8,9,2,3,4,5]; // 곱해줄 숫자 배열

            // 1. 각자리에 2,3,4,5,6,7,8,9,2,3,4,5를 곱해줌. 단 마지막 자리는 빼놓음
            for(let i=0; i<rrn.length-1; i++){
                rrn[i] = rrn[i] * ckarr[i];
            }
            var rrnlast = rrn[rrn.length-1]; // 주민등록번호 마지막자리 따로 빼두기

            // 2. 각 자리의 숫자를 모두 더함
            var sum = 0;
            for(let i=0; i<rrn.length-1; i++){
                sum += rrn[i];
            }

            //3. 11로 나눈 나머지 값을 구함
            sum = sum % 11;

            // 4. 11에서 결과값을 뺌(단, 마지막 결과가 두자리인 경우 다시 10으로 나눈 나머지 값을 구함)

            sum = 11 - sum;

            if(sum > 9){
                sum = sum % 10;
            }
            
            // 5. 결과가 주민등록번호 마지막 자리와 일치하면 유효한 주민등록번호임
            if(sum == rrnlast){ // 결과값과 주민등록번호 마지막 번호가 일치한다면
               //id가 result인 Element에 해당 값 삽입
            $("#RRNresult").html("유효한 주민번호입니다.");
            $("#RRNresult").css("color","blue")
            console.log(rrn)
            }
            if(sum != rrnlast && rrnlast != undefined){ 
            // 결과값과 주민등록번호 마지막 번호가 일치하지않는다면
            //id가 result인 Element에 해당 값 삽입
            $("#RRNresult").html("유효하지 않은 주민번호입니다.");
            $("#RRNresult").css("color","blue");
            }
        }
        
</script>

</html>