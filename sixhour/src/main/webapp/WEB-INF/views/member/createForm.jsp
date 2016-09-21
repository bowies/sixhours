<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직원 정보 등록</title>

</head>
<body>


	<FORM name='frm' method='POST' action='./create'>

		<TABLE>

			<tr>
				<th>직원번호</th>
				<td><input type="text" name="mnum" maxlength="3"></td>
			</tr>
			<tr>
				<th>직급</th>
				<td><input type="text" name="mgrade"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="mname"></td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td><input type="text" name="mphone"></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="text" name="memail"></td>
			</tr>

		</TABLE>

		<input type='submit' value='회원가입'> <input type='reset'
			value='취소'>

	</FORM>



</body>
</html>
