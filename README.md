# Connecting android to MySQL database

>Uses Volley Library


##### Note: The app is merely simple, I wrote the php scripts (with the help of a friend) and the app just to learn the basics of RESTful api services and consuming the api on Android.
### Future enhancements:
* ~~~Create products from android phone.~~~
* View details of a product on clicking a particular item in all products listview.
* ~~~Update existing products.~~~
* ~~~Delete products.~~~
* ~~~Upload php scripts and database to remote server.~~~

### To test:
>Do not follow striked steps as they were to setup database on local server. The database and php scripts have been moved to the remote server. So you only need to get the app running to test this
* Clone the repo: `git clone https://github.com/pfieffer/ConnDB.git` or `git clone git@github.com:pfieffer/ConnDB.git` OR Download the zip.
* ~~~Move contents of `php_scripts` to your `htdocs/androidTest/` folder.~~~
* ~~~Create database using the query at `db/products.sql` or simply importing the same. I have set the name of the database as `phone_iinfo`~~~
* ~~~Change the ip addresses at `baseUrl` in `app/src/main/java/np/com/ravi/dbconn/app/Appcontroller.java` to your ipaddress. Use `ifconfig` on terminal `ipconfig` on cmd(windows) to view your ip address.~~~
* ~~~Start localhost using `sudo /opt/lampp/lampp start` on linux / using XAMPP on Windows.~~~
* ~~~Run the app on phone, connect the phone and PC to the same Wifi Network and the app should run seemlessly.~~~
* Open the app project on Android Studio and run the app on phone.

The `build.gradle` file `Module:app` of the project is:
```GRADLE
apply plugin: 'com.android.application'

android {
    compileSdkVersion 25
    buildToolsVersion "25.0.3"
    defaultConfig {
        applicationId "np.com.ravi.dbconn"
        minSdkVersion 15
        targetSdkVersion 25
        versionCode 1
        versionName "1.0"
        testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }
}

dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    androidTestCompile('com.android.support.test.espresso:espresso-core:2.2.2', {
        exclude group: 'com.android.support', module: 'support-annotations'
    })

    compile files('libs/volley.jar')
    compile 'com.android.support:appcompat-v7:25.3.1'
    compile 'com.android.support.constraint:constraint-layout:1.0.2'
    testCompile 'junit:junit:4.12'
}

```

---

The sceenshot of JSON fetched from database is as follows:<br>
![JSON response](screenshots/ConnDBjson.PNG?raw=true)

---

All Products|Add a product|Update a product|Delete a Product
-|-|-|-|
![All Products](screenshots/ViewAllProducts.png?raw=true)|![Add product](screenshots/AddProductActivity.png?raw=true)|![Update product](screenshots/UpdateProductActivity.png?raw=true)|![Delete product](screenshots/DeleteProductActivity.png?raw=true)