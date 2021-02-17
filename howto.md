# How to add a cookbook

## Using zip link

If the listing in the index has a `download.zip` link

1. Right click on the "download.zip" link next to the wanted cookbook and copy the linked URL
2. Open up Sensei and add a cookbook  
![Add a cookbook](images/add_cookbook.png)
3. Add cookbook inside sensei using the zip URL as the location and give it a recognizable ID
![Cookbook configuration](images/cookbook_settings.png)

## From a zip locally

If the listing in the index has a `download.zip` link

1. Download the `.zip` using the "download.zip" link next to the wanted cookbook
2. Unzip the downloaded `.zip` file and move to a local folder located on your local drive
2. Open up Sensei and add a cookbook  
![Add a cookbook](images/add_cookbook.png)
3. Add cookbook inside sensei using the local folder as the location and give it a recognizable ID
![Cookbook configuration](images/cookbook-from-folder.png)

## From a Github repo directly

Some of the cookbooks will be in repositories which support direct use in Sensei. These will be listed in the index with a `use .git` link or URL.

1. Copy the URL linked to
   a. Right click and choose `Copy Link Address`

![Copy Link Address in Browser](images/copy-link-address.png)

2. Open up Sensei and add a cookbook

![Add a cookbook](images/add_cookbook.png)

3. Add cookbook inside sensei using the copied URL as the location and give it a recognizable ID

![Cookbook configuration](images/cookbook-from-git-url.png)


Some cookbooks may be stored in a folder, in which case the URL to add will be displayed in the details of the listing, rather than linked to e.g.

`use .git : https://github.com/SecureCodeWarrior/sensei-blog-examples.git|master|.sensei`

In this case, copy and paste the url and user this as the location when Adding a cookbook
