# Connecting android to local database

>Uses Volley Library

### Future enhancements:
* ~~~Create products from android phone.~~~
* View details of a product on clicking a particular item in all products listview.
* ~~~Update existing products.~~~
* ~~~Delete products.~~~
* ~~~Upload php scripts and database to remote server.~~~

### To test:
* Clone the repo: `git clone https://github.com/pfieffer/ConnDB.git` or `git clone git@github.com:pfieffer/ConnDB.git` OR Download the zip. Open in Android Studio.
* ~~~Move contents of `php_scripts` to your `htdocs/androidTest/` folder.~~~
* ~~~Create database using the query at `db/products.sql` or simply importing the same. I have set the name of the database as `phone_iinfo`~~~
* ~~~Change the ip addresses at `baseUrl` in `app/src/main/java/np/com/ravi/dbconn/app/Appcontroller.java` to your ipaddress. Use `ifconfig` on terminal `ipconfig` on cmd(windows) to view your ip address.~~~
* ~~~Start localhost using `sudo /opt/lampp/lampp start` on linux / using XAMPP on Windows.~~~
* Run the app on phone, connect the phone and PC to the same Wifi Network and the app should run seemlessly.

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

The MainActivity looks like:<br>
[![Screenshot_20170802-125105.png](https://s1.postimg.org/cpxzyv8yn/Screenshot_20170802-125105.png)](https://postimg.org/image/vv198mnmj/)

---

The sceenshot of JSON fetched from database is as follows:<br>
 [![Screenshot from 2017-07-25 16-21-14.png](https://s21.postimg.org/eq4821bc7/Screenshot_from_2017-07-25_16-21-14.png)](https://postimg.org/image/l3tb5ag83/)

---

The View all products activity looks like:<br>
 [![Screenshot_20170801-164121.png](https://s3.postimg.org/9sianiadv/Screenshot_20170801-164121.png)](https://postimg.org/image/wh7hn2rrj/)

---

The AddProductActivity looks like:<br>
 [![Screenshot_20170801-164131.png](https://s3.postimg.org/sjk7xo4yb/Screenshot_20170801-164131.png)](https://postimg.org/image/hjz0m2ej3/)
[![Screenshot_20170801-164214.png](https://s3.postimg.org/pbfqkmioj/Screenshot_20170801-164214.png)](https://postimg.org/image/m4l70zy8f/)

---

The UpdateProductActivity looks like:<br>
 [![Screenshot_20170801-164236.png](https://s3.postimg.org/yaaebecyb/Screenshot_20170801-164236.png)](https://postimg.org/image/6mxoxarrj/)
