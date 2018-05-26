 <%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>测试9</title>
</head>
<body>
<form action="/PhotoFilter/index" method="post"  enctype="multipart/form-data" target="_blank" >
    <table>
        <tr>
            <td width="104" height="25" align="center">Name:</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td width="104" height="25" align="center" >Photo:</td>
            <td><input type="file"  name="Photo" ></td>
        </tr>
        <tr align="center" >
            <td height="25" colspan="3">
                <input type="reset" name="resetBtn" value="重置">
                <input type="submit" name="submitBtn" value="提交">
            </td>
        </tr>
    </table>
</form>
</body>
<html>