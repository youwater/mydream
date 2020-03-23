	
	// 이렇게 하면 편함 생대로 되서 기분 좋음
	function ajaxCall(url,type,data,success){
		$.ajax({
			    type : type, // 타입
			    url : url, // URL
			    async : false, // 비동기화 여부
			    headers : { // Http header
			      "Content-Type" : "application/json",
			      "X-HTTP-Method-Override" : "POST"
			    },
			    dataType : 'json', // 데이터 타입
			    data : JSON.stringify(data),
					success : function(result) { // 결과 성공
					success(result)
				},
			    error : function(request, status, error) { // 결과 에러
			    }
				});

			}
	function ajaxCall2(url,type,data,success){
		$.ajax({
			    type : type, // 타입
			    url : url, // URL
			    cache : false,
			    dataType : 'json', // 데이터 타입
			    data : encodeURI(data),
					success : function(result) { // 결과 성공
					success(result)
				},
			    error : function(request, status, error) { // 결과 에러
			    }
				});

			}

	function formatDate(date) {
		var d = new Date(date), month = '' + 
		(d.getMonth() + 1), day = '' 
		+ d.getDate(), year = d.getFullYear(); if (month.length < 2) month = '0' 
		+ month; if (day.length < 2) day = '0' 
		+ day; 
		return [year, month, day].join('-'); 
		}
