var flag8 = false;
var flag9 = false;
var flag10 = false;
var flag11 = false;
var flag12 = false;
var flag13 = false;
var flag14 = false;
$(function(){
      var $username2 = $("#username2");
      
      var $password3 = $("#password3");
      var $password4 = $("#password4");
     
      var $name2 = $("#name2");

      var $age2 = $("#age2");

      var $phone2 = $("#phone2");
 
      var $address2 = $("#address2");
      $username2.blur(function(){
        var username = $username2.val();
        if(username == "" || username == null){
          flag8 = false;
          $("#username2Span").html("输入不能为空").css("color","red");
          return flag8;
        }else{
          var reg = /^[0-9]{10}$/;
          if(reg.test(username) != true){
            $("#username2Span").html("请输入10位数字").css("color","red");
            flag8 = false;
          }else{
            $.ajax({
              url:"CheckSellerName",
              type:"post",
              datatype:"json",
              data:{
                "username":username
              },
              success:function(msg){
                if(msg == 1){
                  flag8 = false;
                  $("#username2Span").html("用户名被占用").css("color","red");
                }else{
                  flag8 = true;
                  $("#username2Span").html("").css("color","green");
                }
              }
            });
          }
        }
      });
      $password3.blur(function() {
        var password = $password3.val();
        if(password =="" || password == null){
          flag9 = false;
          $("#password3Span").html("输入不能为空").css("color","red");
          return flag9;
        }else{
          var reg = /^(\w){6,14}$/;
          if(reg.test(password)!=true){
            flag9 = false;
              $("#password3Span").html("请输入6-14位数字或者英文字母").css("color","red");
          }else{
            $("#password3Span").html("");
            flag9 = true;
          }
        }
      });
      $password4.blur(function(){
        var password1 = $password3.val();
        var password2 = $password4.val();
        if (password2 ==""||password2==null) {
          flag10 = false;
          $("#password4Span").html("输入不能为空").css("color","red");
          return flag10;
        }
        else{
          if (password1 != password2) {
            flag10 = false;
              $("#password4Span").html("请确认您的密码").css("color","red");
          }else{
            $("#password4Span").html("");
            flag10 = true;
          }
        }
      })
      $name2.blur(function(){
        var name = $name2.val();
        if (name =="" || name==null) {
          flag11 = false;
          $("#name2Span").html("输入不能为空").css("color","red");
          return flag11;
        }else{
            $("#name2Span").html("").css("color","red");
             flag11 = true;
        }
      });
      $age2.blur(function(){
        var age1 = $age2.val();
        if (age1 ==""||age1==null){
          flag12 = false;
          $("#age2Span").html("输入不能为空").css("color","red");
          return flag12;
        }else{
          var reg = /[1-9]\d*/;
          if((age1 < 18||age1 > 50) || reg.test(age1)!=true){
            flag12 = false;
              $("#age2Span").html("请输入有效年龄").css("color","red");
          }else{
            $("#age2Span").html("");
            flag12 = true;
          }
        }
      });
      $phone2.blur(function(){
        var phone = $phone2.val();
        if(phone==""||phone==null){
          flag13 = false;
          $("#phone2Span").html("输入不能为空").css("color","red");
          return flag13;
        }else{
          var pattern = /0?(13|14|15|18)[0-9]{9}/;
          if(pattern.test(phone)!=true){
            flag13 = false;
              $("#phone2Span").html("请输入有效电话").css("color","red");
          }else{
            $("#phone2Span").html("");
            flag13 = true;
          }
        }
      });
      $address2.blur(function(){
        var address = $address2.val();
        if(address==""||address==null){
          flag14 = false;
          $("#address2Span").html("输入不能为空").css("color","red");
        }else{
          var pattern = /[\u4e00-\u9fa5]/;
          if(pattern.test(address)!=true){
            flag14 = false;
              $("#address2Span").html("请输入有效地址").css("color","red");
          }else{
            flag14 = true;
            $("#address2Span").html("");
          }
        }
      })
    });

  function submitSeller(){
    if(flag8 && flag9 && flag10&&flag11&&flag12&&flag13&&flag14){
      $("#saleregister").submit();
    }else{
      alert("请正确填写所有信息");
    }
  }