/**
 * 
 */
 
 let websocket=new WebSocket("ws:"+window.location.hostname+":8080/WebSocket/websocket");
 websocket.onmessage =(message)=>{
	document.getElementById("para").innerText +=message.data+"\n";
	document.getElementById("value").value="";
}


function Send(){
	if(document.getElementById("value").value.trim()!="" && websocket != null){
		 websocket.send(value.value);
	 }
}