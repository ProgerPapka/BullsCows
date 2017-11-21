function valid() {
	var texbox = document.getElementsByClassName('textbox');
	var str = texbox[0].value;
	if(str.length>=4){
		//texbox[0].disabled = true;
		var one = document.getElementById('on').disabled = true;
		var one = document.getElementById('tw').disabled = true;
		var one = document.getElementById('th').disabled = true;
		var one = document.getElementById('fo').disabled = true;
		var one = document.getElementById('fi').disabled = true;
		var one = document.getElementById('si').disabled = true;
		var one = document.getElementById('se').disabled = true;
		var one = document.getElementById('ei').disabled = true;
		var one = document.getElementById('ni').disabled = true;
		var one = document.getElementById('ze').disabled = true;
	}
	return false;
}

function one(){
	var texbox = document.getElementsByClassName('textbox');
	texbox[0].value+="1";
	var one = document.getElementById('on').disabled = true;
	valid();
	return false;
}

function two(){
	var texbox = document.getElementsByClassName('textbox');
	texbox[0].value+="2";
	var one = document.getElementById('tw').disabled = true;
	valid();
	return false;
}

function three(){
	var texbox = document.getElementsByClassName('textbox');
	texbox[0].value+="3";
	var one = document.getElementById('th').disabled = true;
	valid();
	return false;
}

function four(){
	var texbox = document.getElementsByClassName('textbox');
	texbox[0].value+="4";
	var one = document.getElementById('fo').disabled = true;
	valid();
	return false;
}

function five(){
	var texbox = document.getElementsByClassName('textbox');
	texbox[0].value+="5";
	var one = document.getElementById('fi').disabled = true;
	valid();
	return false;
}

function six(){
	var texbox = document.getElementsByClassName('textbox');
	texbox[0].value+="6";
	var one = document.getElementById('si').disabled = true;
	valid();
	return false;
}

function seven(){
	var texbox = document.getElementsByClassName('textbox');
	texbox[0].value+="7";
	var one = document.getElementById('se').disabled = true;
	valid();
	return false;
}

function eight(){
	var texbox = document.getElementsByClassName('textbox');
	texbox[0].value+="8";
	var one = document.getElementById('ei').disabled = true;
	valid();
	return false;
}

function nine(){
	var texbox = document.getElementsByClassName('textbox');
	texbox[0].value+="9";
	var one = document.getElementById('ni').disabled = true;
	valid();
	return false;
}

function zero(){
	var texbox = document.getElementsByClassName('textbox');
	texbox[0].value+="0";
	var one = document.getElementById('ze').disabled = true;
	valid();
	return false;
}

function clearr(){
	var texbox = document.getElementsByClassName('textbox');
	texbox[0].value="";
	//texbox[0].disabled = false;
	var one = document.getElementById('on').disabled = false;
	var one = document.getElementById('tw').disabled = false;
	var one = document.getElementById('th').disabled = false;
	var one = document.getElementById('fo').disabled = false;
	var one = document.getElementById('fi').disabled = false;
	var one = document.getElementById('si').disabled = false;
	var one = document.getElementById('se').disabled = false;
	var one = document.getElementById('ei').disabled = false;
	var one = document.getElementById('ni').disabled = false;
	var one = document.getElementById('ze').disabled = false;
	return false;
}

function reg() {
    var pas1 = document.getElementById('pas1').value;
    var pas2 = document.getElementById('pas2').value;

    if(pas1 !== pas2) {
        alert("Пароли не совпадают введите заново!");
        document.getElementById('pas1').value = "";
        document.getElementById('pas2').value = "";
        document.getElementById('log').value = "";
        return false;
    }else {
    	return true;
	}
}