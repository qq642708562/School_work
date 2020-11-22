function fillProvince() {
    $.ajax({
        type: "post",
        url: "queryProvinceCity.do",
        data: {},
        dataType: "json",
        success: function (response) {
            var data = response;
            var provinceElement = document.getElementById("province");
            provinceElement.options.length = 0;
            provinceElement.add(new Option("请选择省份", ""));
            $.each(data, function (index, item) {
                provinceElement.add(new Option(item, index));
            });
        },
        error: function () {
            alert("error");
        }
    });
}

function registerCheck(){
    var flag;
    if($('#userName').val()==""||$('#name').val()==""||$('#mail').val()==""||$('#province').val()==""||
    $('#city').val()==""||$('#password').val()==""||$('#pwd').val()==""){
        flag = "false";
    }else if($("#nameError").text()==""&&$("#realnameError").text()==""&&$("#emailError").text()==""&&
    $("#provinceError").text()==""&&$("#cityError").text()==""&&$("#pwdError").text()==""&&$("#pwdError2").text()==""){
        flag = "true";
    }else{
        flag = "false";
    }
    var data = {
        flag:flag,
        userName: $("#userName").val(),
        password: $("#password").val()
    }; 
    $.ajax({
        type: "post",
        url: "registerCheck.do",
        data: data,
        dataType: "json",
        success: function (response) {
            var data = response.flag;
            if(data=="true"){
                alert("注册成功!");
                window.location.href = "login.html";
            }else{
                alert("注册失败!");
            }
        },
        error: function () {
            alert("error");
        }
    });
}

$(document).ready(function () {
    $("#userName").blur(function () {
        var $name = $('#userName').val();
        var reg =  /^[a-zA-Z][a-zA-Z0-9_]{3,15}$/; 
        if ($name.length == 0) {
            $("#nameError").html('用户名不能为空<br>');
            // $("#s1").text('用户名不能为空');
        }else if(!reg.test($name)){
            $("#nameError").html('用户名只能使用英文字母、数字和下划线,以字母开头,长度为4到15个字符<br>');
        }else{
            $("#nameError").text('');
        }
    });
    $("#name").blur(function () {
        var $name = $('#name').val();
        var reg = /^[\u4E00-\u9FA5]{2,4}$/;
        if ($name.length == 0) {
            $("#realnameError").html('真实姓名不能为空<br>');
        }else if(!reg.test($name)){
            $("#realnameError").html('真实姓名只能是2-4长度的中文<br>');
        }else{
            $("#realnameError").text('');
        }
    });
    $("#mail").blur(function () {
        var $name = $('#mail').val();
        var reg = /^[0-9a-zA-Z_.-]+[@][0-9a-zA-Z_.-]+([.][a-zA-Z]+){1,2}$/;
        if ($name.length == 0) {
            $("#emailError").html('邮箱不能为空<br>');
        }else if(!reg.test($name)){
            $("#emailError").html('请输入正确的邮箱格式<br>');
        }else{
            $("#emailError").text('');
        }
    });
    $("#password").blur(function () {
        var $name = $('#password').val();
        var reg = /^[0-9A-Za-z-_\~!@#\$%\^&\*\.\(\)\[\]\{\}<>\?\\\/\'\"\+;:,|=]{6,15}$/;
        if ($name.length == 0) {
            $("#pwdError").html('密码不能为空<br>');
        }else if(!reg.test($name)){
            $("#pwdError").html('请输入6~15位的密码<br>');
        }else{
            $("#pwdError").text('');
        }
    });
    $("#pwd").blur(function () {
        var $name1 = $('#password').val();
        var $name2 = $('#pwd').val();
        if ($name2.length == 0) {
            $("#pwdError2").html('确认密码不能为空<br>');
        }else if($name1!=$name2){
            $("#pwdError2").html('密码不一致<br>');
        }else{
            $("#pwdError2").text('');
        }
    });
    fillProvince();
    $("#province").change(function () {
        if ($("#province").val() == "") {
            $("#provinceError").css("color", "red");
            $("#provinceError").html("必须选择省份<br>");
        }else{
            $("#provinceError").text("");
            var provinceCode = $("#province").val();
            $.ajax({
                type: "post",
                url: "queryProvinceCity.do",
                data: { provinceCode: provinceCode },
                dataType: "json",
                success: function (response) {
                    var data = response;
                    $("#city").empty();
                    var opt = $("<option>").val("").text("请选择城市");
                    $("#city").append(opt);
                    $.each(data, function (index, item) {
                        var option = $("<option>").val(index).text(item);
                        $("#city").append(option);
                    });
                },
                error: function () {
                    alert("error");
                }
            });
        }

    });

    $("#city").change(function () {
        if ($("#city").val() == "") {
            $("#cityError").css("color", "red");
            $("#cityError").html("必须选择城市<br>");
        }else{
            $("#cityError").text("");
        }
    });
});