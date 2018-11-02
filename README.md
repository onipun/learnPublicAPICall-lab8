# learnPublicAPICall-lab8
this repo is an example of how to call PixaBay's images via Public API

******PUBLIC API************
https://pixabay.com/api/

******PARAMATER THAT ABLE TO RECIEVE*********
key (required) - 	Your API key: 
q -	A URL encoded search term. If omitted, all images are returned. This value may not exceed 100 characters.
Example: "yellow+flower"

lang -	Language code of the language to be searched in.
Accepted values: cs, da, de, en, es, fr, id, it, hu, nl, no, pl, pt, ro, sk, fi, sv, tr, vi, th, bg, ru, el, ja, ko, zh
Default: "en"

image_type - 	Filter results by image type.
Accepted values: "all", "photo", "illustration", "vector"
Default: "all"
orientation -	Whether an image is wider than it is tall, or taller than it is wide.
Accepted values: "all", "horizontal", "vertical"
Default: "all"

category - 	Filter results by category.
Accepted values: fashion, nature, backgrounds, science, education, people, feelings, religion, health, places, animals, industry, food, computer, sports, transportation, travel, buildings, business, music
min_width - 	Minimum image width.
Default: "0"

min_height - 	Minimum image height.
Default: "0"
colors -	Filter images by color properties. A comma separated list of values may be used to select multiple properties.
Accepted values: "grayscale", "transparent", "red", "orange", "yellow", "green", "turquoise", "blue", "lilac", "pink", "white", "gray", "black", "brown"

editors_choice -	Select images that have received an Editor's Choice award.
Accepted values: "true", "false"
Default: "false"

safesearch - 	A flag indicating that only images suitable for all ages should be returned.
Accepted values: "true", "false"
Default: "false"

order -	How the results should be ordered.
Accepted values: "popular", "latest"
Default: "popular"

page -	Returned search results are paginated. Use this parameter to select the page number.
Default: 1

per_page -	Determine the number of results per page.
Accepted values: 3 - 200
Default: 20

callback -	JSONP callback function name

pretty -	Indent JSON output. This option should not be used in production.

Accepted values: "true", "false"
Default: "false"


******EXAMPLE API RESPONSE***
{
	"total": 4692,
	"totalHits": 500,
	"hits": [
	    {
	        "id": 195893,
	        "pageURL": "https://pixabay.com/en/blossom-bloom-flower-195893/",
	        "type": "photo",
	        "tags": "blossom, bloom, flower",
	        "previewURL": "https://cdn.pixabay.com/photo/2013/10/15/09/12/flower-195893_150.jpg"
	        "previewWidth": 150,
	        "previewHeight": 84,
	        "webformatURL": "https://pixabay.com/get/35bbf209e13e39d2_640.jpg",
	        "webformatWidth": 640,
	        "webformatHeight": 360,
	        "largeImageURL": "https://pixabay.com/get/ed6a99fd0a76647_1280.jpg",
	        "fullHDURL": "https://pixabay.com/get/ed6a9369fd0a76647_1920.jpg",
	        "imageURL": "https://pixabay.com/get/ed6a9364a9fd0a76647.jpg",
	        "imageWidth": 4000,
	        "imageHeight": 2250,
	        "imageSize": 4731420,
	        "views": 7671,
	        "downloads": 6439,
	        "favorites": 1,
	        "likes": 5,
	        "comments": 2,
	        "user_id": 48777,
	        "user": "Josch13",
	        "userImageURL": "https://cdn.pixabay.com/user/2013/11/05/02-10-23-764_250x250.jpg",
	    },
	    {
	        "id": 73424,
	        ...
	    },
	    ...
	]
	}
  
  
