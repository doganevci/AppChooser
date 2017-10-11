# AppChooser
Properties
- Native App <-> WebApp Communication with bridge between Java and Javascript
- The native app sends location, battery, accelerometer data when native receiver gets.
- UI design

#NEWS!!
You can easily create new webapp with extending WebappSuperFragment (which is abstract class implementing WebAppInterface.)


Libraries
- Google Play Services: Location
- Dexter: for runtime permissions.
- android-viewpager-transformers: 


Components

- viewPager for app chosen
- fragments with web views for webapps.
- Javascript Bridge interface for sending command from web app to native app.

Other libraries comes with default android project (Like design lib, app combat…). For appchoser animation; i used and manipulated view pager component. Maybe it isn’t exactly same as your design but very similar . Because, in my opinion with using an ui element  you can save time and create more solid structures.

ViewPager is defaultly set left to right. So i rotate view 180 degree. But if i rotate the view, fragments looks like looking from mirror. So also rotate the fragments 180 degree.

