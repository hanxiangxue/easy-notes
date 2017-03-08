
<html >

<head>
<meta charset="UTF-8" />
<#include "commen.ftl" >
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script type="text/javascript" src="${ctx}/static/js/jquery-1.5.1.min.js"></script>
<script type="text/javascript" src="${ctx}/js/login.js"></script>
<link rel="stylesheet" href="${ctx}/static/login/bootstrap.min.css" />
<link rel="stylesheet" href="${ctx}/static/login/css/camera.css" />
<link rel="stylesheet" href="${ctx}/static/login/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="${ctx}/static/login/matrix-login.css" />
<link href="${ctx}/static/login/font-awesome.css" rel="stylesheet" />

</head>
<body>

	<div
		style="width:100%;text-align: center;margin: 0 auto;position: absolute;">
		<div id="loginbox">
			<form action="" method="post" name="loginForm"
				id="loginForm">
				<div class="control-group normal_text">
					<h3>
						<img src="${ctx}/static/login/logo.png" alt="Logo" />
					</h3>
				</div>
				<div class="control-group">
					<div class="controls">
						<div class="main_input_box">
							<span class="add-on bg_lg">
							<i><img height="37" src="${ctx}/static/login/user.png" /></i>
							</span><input type="text" name="loginname" id="loginname" value="" placeholder="请输入用户名" />
						</div>
					</div>
				</div>
				<div class="control-group">
					<div class="controls">
						<div class="main_input_box">
							<span class="add-on bg_ly">
							<i><img height="37" src="${ctx}/static/login/suo.png" /></i>
							</span><input type="password" name="password" id="password" placeholder="请输入密码" value="" />
						</div>
					</div>
				</div>
				<div style="float:right;padding-right:10%;">
					<div style="float: left;margin-top:3px;margin-right:2px;">
						<font color="white">记住密码</font>
					</div>
					<div style="float: left;">
						<input name="form-field-checkbox" id="saveid" type="checkbox"
							onclick="savePaw();" style="padding-top:0px;" />
					</div>
				</div>
				<div class="form-actions">
					<div style="width:86%;padding-left:8%;">

						<div style="float: left;">
							<i><img src="${ctx}/static/login/yan.png" /></i>
						</div>
						<div style="float: left;" class="codediv">
							<input type="text" name="code" id="code" class="login_code"
								style="height:16px; padding-top:0px;" />
						</div>
						<div style="float: left;">
							<i><img style="height:22px;" id="codeImg" alt="点击更换"
								title="点击更换" src="" /></i>
						</div>

						<span class="pull-right" style="padding-right:3%;"><a
							href="javascript:quxiao();" class="btn btn-success">取消</a></span> <span
							class="pull-right"><a onclick="severCheck();"
							class="flip-link btn btn-info" id="to-recover">登录</a></span>

					</div>
				</div>

			</form>


			<div class="controls">
				<div class="main_input_box">
					<font color="white"><span id="nameerr">Copyright © FH
							2100</span></font>
				</div>
			</div>
		</div>
	</div>
	<div id="templatemo_banner_slide" class="container_wapper">
		<div class="camera_wrap camera_emboss" id="camera_slide">
			<div data-src="${ctx}/static/login/images/banner_slide_01.jpg"></div>
			<div data-src="${ctx}/static/login/images/banner_slide_02.jpg"></div>
			<div data-src="${ctx}/static/login/images/banner_slide_03.jpg"></div>
		</div>
		<!-- #camera_wrap_3 -->
	</div>

	
	


	<script src="${ctx}/static/js/bootstrap.min.js"></script>
	<script src="${ctx}/static/js/jquery-1.7.2.js"></script>
	<script src="${ctx}/static/login/js/jquery.easing.1.3.js"></script>
	<script src="${ctx}/static/login/js/jquery.mobile.customized.min.js"></script>
	<script src="${ctx}/static/login/js/camera.min.js"></script>
	<script src="${ctx}/static/login/js/templatemo_script.js"></script>
	<script type="text/javascript" src="${ctx}/static/js/jquery.tips.js"></script>
	<script type="text/javascript" src="${ctx}/static/js/jquery.cookie.js"></script>
</body>

</html>