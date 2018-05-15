var flag1 = false;
var flag2 = false;
$(function(){
  var $money = $("#money");
  var $title = $("#title");
	var $textarea = $("#textarea");
	$textarea.blur(function(){
        var textarea = $textarea.val();
        if (textarea ==""||textarea==null) {
          flag1 = false;
          $("#textareaSpan").html("请介绍一下你的宝贝").css("color","red");
          return flag1;
        }else{
            $("#textareaSpan").html("");
        }
    })
  $title.blur(function(){
        var title = $title.val();
        if (title ==""||title==null) {

          flag2 = false;
           $("#titleSpan").html("请给你的宝贝想个标题").css("color","red");
          // $("#titleSpan").html("输入不能为空").css("color","red");
          return flag2;
        }else if (title.length >10){
          flag2 = false;
          $("#titleSpan").html("标题在十字符以内");
        }else{
          flag2=true;
            $("#titleSpan").html("");
        }
      })
  $money.blur(function(){
        var reg = /^[0-9]+(.[0-9]{2})?/; 
        var money = $money.val();
        if (money ==""||money==null) {
          flag3 = false;
           $("#moneySpan").html("请为你的宝贝设定价格").css("color","red");
          return flag3;
        }else{
            if(reg.test(money)!=true){
               $("#moneySpan").html("请设定正确的价格").css("color","red");
            }else{
               $("#moneySpan").html(""); 
            }
        }
      })
});
function uploadSubmit(){
  var $file=$("#file");
  var reg = /.(PNG|JPG|GIF|png|jpg|gif)$/; 
  var fileName = $file.val();
  if(flag2){
	  if(reg.test(fileName)){
		  $("#uploadform").submit();
	  }else{
		  alert("请上传正常图片");
	  }
  }else{
    alert("请正确填写所有信息");
  }
}
function checkFile(){
	$("#file").click();
	
}