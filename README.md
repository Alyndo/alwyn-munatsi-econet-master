# Alwyn-Munatsi


#-----To Run System-----#

Access the jar "econet-0.0.1-SNAPSHOT.jar." in the target folder.
run command java -jar econet-0.0.1-SNAPSHOT.jar 
access the system using the url :   http://localhost:3088/econet/area  either from browser or postman 

####Video Link #######

https://drive.google.com/file/d/1cLNSRdkgZtxqYtO0UA2_6RKRUt7wFY3N/view?usp=drive_link

################## GET AREAS ##########################
curl --request GET \
  --url http://localhost:3088/area \
  --header 'Content-Type: application/json' 
  
  
  
 ############# GET AREA BY ID ######################
  
  curl --request GET \
  --url http://localhost:3088/area/findById/1 \
  --header 'Content-Type: application/json' \
  --data '	{
			"id": 1,
			"name": "CBD",
			"shops": [
				{
					"name": "First Street"
				}
			]
		}'
    
    
######## SAVE SHOP IN AREA ###################
     curl --request POST \
  --url http://localhost:3088/shop/1/save \
  --header 'Content-Type: application/json' \
  --data '	{
			"name": "First_Street"
		}'
		
######## FIND SHOPS BY AREA NAME #######	

curl --request GET \
  --url http://localhost:3088/shop/Manresa
  
  
