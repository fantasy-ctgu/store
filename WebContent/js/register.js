var flag1 = false;
var flag2 = false;
var flag3 = false;
var flag4 = false;
var flag5 = false;
var flag6 = false;
var flag7 = false;
$(function(){
  var $username1 = $("#username1");
  
  var $password1 = $("#password1");
  var $password2 = $("#password2");
 
  var $name1 = $("#name1");

  var $age1 = $("#age1");

  var $phone1 = $("#phone1");

  var $address1 = $("#address1");
  $username1.blur(function(){
    var username = $username1.val();
    if(username == "" || username == null){
      flag1 = false;
      $("#username1Span").html("输入不能为空").css("color","red");
      return flag1;
    }else{
      var reg = /^[0-9]{10}$/;
      if(reg.test(username) != true){
        $("#username1Span").html("请输入10位数字").css("color","red");
        flag1 = false;
      }else{
        $.ajax({
          url:"CheckUserName",
          type:"post",
          datatype:"json",
          data:{
            "username":username
          },
          success:function(msg){
            if(msg == 1){
              flag1 = false;
              $("#username1Span").html("用户名被占用").css("color","red");
            }else{
              flag1 = true;
              $("#username1Span").html("").css("color","green");
            }
          }
        });
      }
    }
  });
  $password1.blur(function() {
    var password = $password1.val();
    if(password =="" || password == null){
      flag2 = false;
      $("#password1Span").html("输入不能为空").css("color","red");
      return flag2;
    }else{
      var reg = /^(\w){6,14}$/;
      if(reg.test(password)!=true){
        flag2 = false;
        $("#password1Span").html("请输入6-14位数字或者英文字母").css("color","red");
      }else{
        flag2 = true;
        $("#password1Span").html("");
      }
    }
  });
  $password2.blur(function(){
    var password1 = $password1.val();
    var password2 = $password2.val();
    if (password2 ==""||password2==null) {
      flag3 = false;
      $("#password2Span").html("输入不能为空").css("color","red");
      return flag3;
    }
    else{
      if (password1 != password2) {
        flag3 = false;
        $("#password2Span").html("请确认您的密码").css("color","red");
      }else{
        $("#password2Span").html("");
       flag3 = true;
      }
    }
  });
  $name1.blur(function(){
    var name1 = $name1.val();
    if (name1 ==""||name1==null) {
      flag4 = false;
      $("#name1Span").html("输入不能为空").css("color","red");
      return flag4;
    }else{
        $("#name1Span").html("").css("color","red");
        flag4 = true;
    }
  });
  $age1.blur(function(){
    var age1 = $age1.val();
    if (age1 ==""||age1==null){
      flag5 = false;
      $("#age1Span").html("输入不能为空").css("color","red");
      return flag5;
    }else{
      var reg = /[1-9]\d*/;
      if((age1 < 18||age1 > 50) || reg.test(age1)!=true){
        flag5 = false;
          $("#age1Span").html("请输入有效年龄").css("color","red");
      }else{
        $("#age1Span").html("");
        flag5 = true;
      }
    }
  });
  $phone1.blur(function(){
    var phone = $phone1.val();
    if(phone==""||phone==null){
      flag6 = false;
      $("#phone1Span").html("输入不能为空").css("color","red");
      return flag6;
    }else{
      var pattern = /0?(13|14|15|18)[0-9]{9}/;
      if(pattern.test(phone)!=true){
        flag6 = false;
          $("#phone1Span").html("请输入有效电话").css("color","red");
      }else{
        $("#phone1Span").html("");
        flag6 = true;
      }
    }
  });
  $address1.blur(function(){
    var address = $address1.val();
    if(address==""||address==null){
      flag7 = false;
      $("#address1Span").html("输入不能为空").css("color","red");
    }else{
      var pattern = /[\u4e00-\u9fa5]/;
      if(pattern.test(address)!=true){
        flag7 = false;
          $("#address1Span").html("请输入有效地址").css("color","red");
      }else{
        flag7 = true;
        $("#address1Span").html("");
      }
    }
  });
});

function submitUser(){

    if(flag1 && flag2 && flag3&&flag4&&flag5&&flag6&&flag7){
      $("#normalregister").submit();
    }else{
      alert("请正确填写所有信息");
    }
  }