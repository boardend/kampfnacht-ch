var Backbone = require("backbone");

var Layout = Backbone.Marionette.Layout.extend({
		template: require("./login"),

		events: {
			"click #login-form-register": "transitionRegistration",
		},

		initialize: function(options){
			this.registration = false;
		},

		onShow: function () {
			$('#login-form-mail').focus();
		    $(".login-container").fadeIn(600);
		},

		transitionRegistration: function() {
			if(! this.registration)
				this.transitionRegistrationUp();
			else
				this.transitionRegistrationDown();
		},
		transitionRegistrationUp: function() {
			$(".registration-container").slideDown("slow", function(){
				$('#register-form-user').focus();
				$(".panel").css('background', 'rgba(255, 255, 255, 0.5)');
				$('html, body').animate({scrollTop: $("#login-form-register").offset().top - 5}, 'slow');
			});
			
			$("#login-form-register .glyphicon").removeClass("glyphicon-chevron-down");
			$("#login-form-register .glyphicon").addClass("glyphicon-chevron-up");
			$("#login-form-register .button-text").text("doch nöd");

			$('#login-form-mail').attr("disabled", true);
			$('#login-form-password').attr("disabled", true);
			$('#login-form-rembmber').attr("disabled", true);
			$('#login-form-submit').attr("disabled", true);

			this.registration = true;
		},
		transitionRegistrationDown: function() {
			$(".registration-container").slideUp("slow", function() {
				$('#login-form-mail').focus();
				$(".panel").css('background', 'rgba(255, 255, 255, 0.3)');
				$('html, body').animate({scrollTop: 0}, 'slow');
			});
			$("#login-form-register .glyphicon").removeClass("glyphicon-chevron-up");
			$("#login-form-register .glyphicon").addClass("glyphicon-chevron-down");
			$("#login-form-register .button-text").text("registriere");

			$('#login-form-mail').attr("disabled", false);
			$('#login-form-password').attr("disabled", false);
			$('#login-form-rembmber').attr("disabled", false);
			$('#login-form-submit').attr("disabled", false);

			this.registration = false;
		},
	});
module.exports = Layout;