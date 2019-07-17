window.addEventListener("load", function() {
	var section = this.document.querySelector("#upload");
	var dropZone = section.querySelector(".drop-zone");
	var fileButton = section.querySelector("input[type=file]");
	var trigButton = section.querySelector(".triger");
	var percentSpan = section.querySelector(".percent");

	dropZone.addEventListener("dragenter", function(e) {
		e.preventDefault();

		console.log("들어왔냐?")

		for ( var key in e.dataTransfer)
			console.log(key);

		for ( var key in e.dataTransfer.types[0])
			console.log(e.dataTransfer.types[0]);
	});
	dropZone.addEventListener("dragleave", function(e) {
		e.preventDefault();
		dropZone.classList.remove("invalide");
		dropZone.classList.remove("valide");
		console.log("E떠날거니")
	});
	dropZone.addEventListener("dragover", function(e) {
		e.preventDefault();
		// dropZone.classList.remove("invalide")
		console.log("이동중")
		if (e.dataTransfer.types != "Files") {
			// alert("잘못된것입니다.")
			dropZone.classList.add("invalide")
		} else {
			dropZone.classList.add("valide")
		}
		// window.setInterval()
	});

	dropZone.addEventListener("drop", function(e) {
		e.preventDefault();

		var files = e.dataTransfer.files;
		var size = files.length;

		if (size > 1) {
			alert("파일은 하나씩만 업로드 할 수 있습니다.");
			return;
		}

		var file = files[0];
		console.log(file.type);// 파일종류

//		var regex = new RegExp("image/(jpeg|png|gif)");
//		if (!file.type.match(regex)) {
//			alert("유효하지않은 파일형식입ㄴ미다")
//			return;
//		}

		// if(file.type.match(/image(jpeg|png|gif)/)){
		// alert("유효하지않은 파일형식입ㄴ미다")
		// return;
		// }
		//    

		if (file.size > 10 * 1024 * 1024) {
			alert("10메가 이상의 파일은 업로드 할 수 없습니다.");
			return;
		}
		console.log("내려놨니?")

		var formData = new FormData();
		formData.append("file", file);

		var request = new XMLHttpRequest();
		request.addEventListener("load", function() {
			alert(request.responseText);

		});
		request.upload.addEventListener("progress",function(e){
			console.log(e.loaded);
			if(e.lengthComputable)
				console.log(Math.round(e.loaded * 100/e.total));
			percentSpan.innerText=Math.round(e.loaded * 100/e.total);
		});
		request.open("POST", "../../../upload");
		request.send(formData);

	});

	trigButton.onclick = function(e) {
		console.log("aa");

		var event = new MouseEvent("click", {
			view : window,
			bubbles : true,
			cancelable : true
		});

		fileButton.dispatchEvent(event);

	}

});