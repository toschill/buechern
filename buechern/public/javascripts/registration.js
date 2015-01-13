		function checkReg(){	
			var fehler = false;
			if(document.getElementById("FirstName").value===""){
				document.getElementById("FirstName").style = "border:1px solid red";
				fehler=true;
			}
			else{
				document.getElementById("FirstName").style = "border:1px solid green";
			}
			if(document.getElementById("LastName").value===""){
				document.getElementById("LastName").style = "border:1px solid red";
				fehler=true;
			}
			else{
				document.getElementById("LastName").style = "border:1px solid green";
			}
			if((document.getElementById("Email").value==="")||!(validateEmail(document.getElementById("EmailRep").value))){
				document.getElementById("Email").style = "border:1px solid red";
				fehler=true;
			}
			else{
				document.getElementById("Email").style = "border:1px solid green";
			}
			if(document.getElementById("Passwort").value===""){
				document.getElementById("Passwort").style = "border:1px solid red";
				fehler=true;
			}
			else{
				document.getElementById("Passwort").style = "border:1px solid green";
			}
			if((!(document.getElementById("EmailRep").value===document.getElementById("Email").value))||(document.getElementById("EmailRep").value==="")){
				document.getElementById("EmailRep").style = "border:1px solid red";
				fehler=true;
			}
			else{
				document.getElementById("EmailRep").style = "border:1px solid green";
			}
			if((!(document.getElementById("PasswortRep").value===document.getElementById("Passwort").value))||(document.getElementById("PasswortRep").value==="")){
				document.getElementById("PasswortRep").style = "border:1px solid red";
				fehler=true;	
			}
			else{
				document.getElementById("PasswortRep").style = "border:1px solid green";
			}

			if(fehler){
				return false;
			}
			else{
				return true;
			}
			
		}

		function validateEmail(email) { 
    		var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    		return re.test(email);
		}

		function resetAll(){
			//null erzeugt default style
			document.getElementById("FirstName").style = null;
			document.getElementById("LastName").style = null;
			document.getElementById("Email").style = null;
			document.getElementById("EmailRep").style = null;
			document.getElementById("Passwort").style = null;
			document.getElementById("PasswortRep").style = null;
		}