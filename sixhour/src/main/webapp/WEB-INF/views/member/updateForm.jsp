<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<body>


	<FORM name='frm' method='POST' action='./update'>

		<input type="hidden" name="mnum" value="${dto.mnum}">
		<input type="hidden" name="eclick" value=0> 
		<TABLE>
	
			<tr>
				<th>직원번호</th>
				<td><input type="text" name="mnum" value="${dto.mnum }"></td>
			</tr>
			<tr>
				<th>직급</th>
				<td><input type="text" name="mgrade" value="${dto.mgrade}"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="mname" value="${dto.mname }"></td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td><input type="text" name="mphone" value="${dto.mphone }"></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="text" name="memail" value="${dto.memail }"></td>
			</tr>

			
		</TABLE>

			<input type='submit' value='수정'>
			<input type='reset'	value='취소'>
	</FORM>

</body>
</html>