$.ajaxSetup({ cache: false });
	
$(document).ready(function() {
	
	$("#login-form").submit(function() {
	//$("#login").click(function() {
		$('.alert').addClass('hidden');

		$.ajax({
			cache   : false,
			url		: '/view/r/login',
			data	: "username=" + $('#username').val() + "&password=" + $('#password').val(),
			type	: 'POST',
		  	beforeSend	: function (xhr) {
			  			  	xhr.setRequestHeader("X-Ajax-call", "true");
					      },
			success : loginSuccess,
			error	: loginError
		});
		
		return false;
	});
	
	loginSuccess = function (data, status) {
		alert(status);
		alert(data.loggedIn);
		alert(data.username);
		if (data.loggedIn) {
			alert('a');
	    	location.href = '/view/index.html';
	    } else {
			alert('b');
			$('#alert-invalid-login').removeClass('hidden');
		}
	};
	
	loginError = function (data, status) {
		alert('c');
		$('#alert-unavailable-login').removeClass('hidden');
	};
});
