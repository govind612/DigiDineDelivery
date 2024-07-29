<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">body{
    display: flex;
    justify-content: center;
    align-items: center;
    min-height: 100vh;
    background: url("https://b.zmtcdn.com/web_assets/81f3ff974d82520780078ba1cfbd453a1583259680.png") no-repeat;
    background-size: cover;
    background-position: center;
}
.wrapper{
    position: relative;
    width: 400px;
    height: 440px;
    background: transparent;
    border: 2px solid rgba(255, 255, 255, .5);
    border-radius: 20px;
    backdrop-filter: blur(20px);
    box-shadow: 0 0 30px rgba(0, 0, 0, .5);
    display: flex;
    justify-content: center;
    align-items: center;
    overflow: hidden;
}
.wrapper .form-box{
    width: 100%;
    padding: 40px;
}
.wrapper .icon-close{
    position: absolute;
    top: 0;
    right: 0;
    width: 45px;
    height: 45px;
    background: black;
    font-size: 2em;
    color: #fff;
    display: flex;
    justify-content: center;
    align-items: center;
    border-bottom-left-radius: 20px;
    cursor: pointer;
    z-index: 1;
}
.form-box h2{
    font-size: 2em;
    color: black;
    text-align: center;
}
.form-box h3{
    font-size: 2em;
}
.input-box{
    position: relative;
    width: 100%;
    height: 50px;
    border-bottom: 2px solid black;
    margin: 30px 0;
}
.input-box label{
    position: absolute;
    top: 50%;
    left: 5px;
    transform: translateY(-50%);
    font-size: 1em;
    color: black;
    font-weight: 500;
    pointer-events: none;
    transition: .5s;
}

.input-box input:focus~label,
.input-box input:valid~label{
    top: -5px;
}

.input-box input{
    width: 100%;
    height: 100%;
    background: transparent;
    border: none;
    outline: none;
    font-size: 1em;
    color: black;
    font-weight: 600;
    padding: 0 35px 0 5px;
}
.input-box .icon{
    position: absolute;
    right: 8px;
    font-size: 1.2em;
    color: black;
    line-height: 57px;
}
.remember-forgot{
    font-size: .9em;
    color: black;
    font-weight: 500;
    margin: -15px 0 15px;
    display: flex;
    justify-content: space-between;
}
.remember-forgot label input{
    accent-color: black;
    margin-right: 3px;
}
.remember-forgot a{
    color: black;
    text-decoration: none;
}
.remember-forgot a:hover{
    text-decoration: underline;
}
.btn{
    width: 100%;
    height: 45px;
    background: black;
    border: none;
    outline: none;
    border-radius: 6px;
    cursor: pointer;
    font-size: 1em;
    color: #fff;
    font-weight: 500;
}
.login-register{
    font-size: .9em;
    color: black;
    text-align: center;
    font-weight: 500;
    margin: 25px 0 10px;
}
.login-register p a{
    color: black;
    text-decoration: none;
    font-weight: 600;
}
.login-register p a:hover{
    text-decoration: underline;
}
label{ color:white;}</style>

</head>
<body>
<form action="register" method="post">

		<label>UserName</label><input type="text" name="username"><br>
			<label>Password</label><input type="text" name="password"><br>
			<label>CPassword</label><input type="text" name="cpassword"><br>
		<label>	Email</label><input type="text" name="email"><br>
			<label>Address</label><input type="text" name="Address"><br>
			<label>Role</label><input type="text" name="role"><br>
		<input type="submit" value="Register Me">
</form>
</body>
</html>