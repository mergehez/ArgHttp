
  <?php 
  $serversideerrortext = "ARG_ERROR"; //ServerSideErrorText
	if(isset($_POST)){
		$author = $_POST["book-author"];
		switch($author){
			case "Mergehez":
				echo 
				   '{
					  "book":[
						  {
							"title": "Introduction to MergeSoft1",
							"author": "Mergehez"
						  },
						  {
							"title": "Introduction to MergeSoft2",
							"author": "Mergehez"
						  },
						  {
							"title": "Introduction to MergeSoft3",
							"author": "Mergehez"
						  },
						  {
							"title": "Introduction to MergeSoft4",
							"author": "Mergehez"
						  }
						]
					}';
				break;
			case "Argeş":
				echo 
				   '{
					  "book":[
						  {
							"title": "Introduction to MergeSoft1",
							"author": "Argeş"
						  },
						  {
							"title": "Introduction to MergeSoft2",
							"author": "Argeş"
						  },
						  {
							"title": "Introduction to MergeSoft3",
							"author": "Argeş"
						  },
						  {
							"title": "Introduction to MergeSoft4",
							"author": "Argeş"
						  }
						]
					}';
				break;
			default:
				echo $serversideerrortext;
				break;
		}
	}else{
		echo $serversideerrortext;
	}
