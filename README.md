# Connecting android to local database

>Uses Volley Library

### Future enhancements:
* ~~~Create products from android phone.~~~
* View details of a product on clicking a particular item in all products listview.
* ~~~Update existing products.~~~
* ~~~Delete products.~~~

### To test:
* Clone the repo
* Move contents of `php_scripts` to your `localhost/androidTest/` folder
* Create database using the query at `db/products.sql` or simply importing the same. I set the name of the database as `phone_iinfo`
* Change the ip addresses at all activities `DeleteProductActivity.java`, `UpdateProductActivity.java`, `NewProductActivity.java` and `ViewProductsActivity.java`
* Start localhost using `sudo /opt/lampp/lampp start` on linux (using XAMPP on Windows)
* Run the app on phone, connect the phone and PC to the same Wifi Network and the app should run seemlessly.

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
