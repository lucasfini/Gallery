# Gallery

## Table of Contents
* [Introduction](#Introduction)
* [History](#History)
* [Major Methods/Components](#Major_Methods_Components)
* [Example Project/Code](#Example_Project_Code)
* [References](#References)


## <a name="Introduction"> Introduction </a>

The android Gallery is a View that shows items in a center-locked, horizontally scrolling list. Although it isn't used anymore, when it was available it allowed users to view photos one at a time, in a organized manner. It uses the interface **Adapter** to populate items to the Gallery. The Adaptor class etends **BaseAdaptor** class and overrides the **getView()** method. It is responsible for making a View for each item in the data set. The **getView()** method uses **Gallery.LayoutParams** as its layout parameters type.

## <a name="History"> History </a>
This component was introduced in **API level 1** and was Deprecated in **API level 16**. Since the widget is no longer supported, some great alternatives are: **HorizontalScrollView** and **ViewPager**. It belongs to the **android.widget.Gallery** class and was included in the **android.view.View** package library.

![image of packages](https://github.com/lucasfini/Gallery/blob/master/images/Screen%20Shot%202019-11-30%20at%206.07.46%20PM.png)

## <a name="Major_Methods_Components">Major Methods/Components</a>

**getCount()** Fetches the length of the image array. This is used to get the exact number of photos that are imported into the project. This is important because it will give the developer data that will be needed for the gallery component. Also, it must be included in the ImageAdaptor class or else their will be a error.

**getItem()** Gets the data associated with the specified position in the list. It provides a way for the developer to access data in the adapter. For example, your adaptor holds integer elements, getItem() will return a int object. 

**getItemId()** Returns the position within the adaptors data set. This allows you to perform multiple operations based on the unique ID of an object in an array or list. For example, if a developer were to have a database with tons of data, if each were uniquely ID'd then the developer can easily perform multiple operations (update/remove) on specific items.

**getView()** This allows the developer to inflate the view into the proper layout parameters. This method allows you to get each item of the Adaptor class to access each element. For example if you create a array and a child view of images (ImageView). To access or modify each element in the Adaptor class you need to have getView.

**setonItemClickListener** This allows a user to click/drag on an image, and get a response in return. It is a Listener that keeps listening for events. When an item in the Gallery has been clicked it will fire up onItemClick callback. 

**onItemClick** This is a Callback method. It is invoked when an item in Gallery has been clicked. 

**.setLayoutParams** Uses **Gallery.LayoutParams** to set the size of the images in ImageView. 

## XML Attributes 

**android:animationDuration** Is used to time how long a transmission animation from one image to another will run for 

**android:gravity** Is used to determine where an object should position its contents. Using the X and Y axis. 

**android:unselectedAlpha** Sets the alpha on the items that are not selected. 

## <a name="Example_Project_Code">Example Project/Code</a>

I have made the code available to download on this github page.

**First:** Import selected images into drawable that you want to view in the Gallery.

![image of drawable](https://github.com/lucasfini/Gallery/blob/master/images/drawable.png)

**Second:** Go into **res/layout/** and use the code below. This creates the layout for Gallery and ImageView. 

**activity_main.xml**
```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity"
    android:background="@android:color/holo_blue_light>
    
    //Create layout for the Gallery.

    <Gallery
        android:id="@+id/gallery"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_alignParentTop="true"
        android:layout_centerHorizontal="true"
        //Major XML ATTRIBUTES
        android:gravity="center"
        android:animationDuration="1000"
        android:unselectedAlpha="10"
        />

    //Create layout to be able to select images.

    <ImageView
        android:id="@+id/imageView"
        android:layout_marginTop="100dp"
        android:layout_width="250dp"
        android:layout_gravity="center_horizontal"
        android:layout_marginTop="100dp"
        android:layout_height="250dp"
        android:src="@drawable/image1" />
</LinearLayout>
```

The **android:src** in <ImageView> points to the first image that will show up in the gallery.

**Third:** Use the code below in your **MainActivity.java**.

```
public class MainActivity extends AppCompatActivity {

    // Variable for ImageView.
    private ImageView sImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO 1.3 Create two variables, one for Gallery and one for ImageView. Attach appropriate ids from layout.
        Gallery ims = (Gallery) findViewById(R.id.gallery);
        sImage = (ImageView) findViewById(R.id.imageView);

        // Spacing Between images. 
        ims.setSpacing(1);
        
          //Moves Images to the bottom.
        ims.setY(1550);

        // TODO 1.4 Create ImageAdaptor class which extends BaseAdaptor. This will work as a bridge between AdapterView and the data source that gets imputed.
        final ImageAdapter gImageAdapter= new ImageAdapter(this);
        ims.setAdapter(gImageAdapter);

       // TODO 1.5 This will allow a user to click on an image, and for response to happen.
       // MAJOR METHOD
        ims.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        // MAJOR METHOD
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                // show the selected Image
                sImage.setImageResource(gImageAdapter.images[position]);
            }
        });
    }
}
```
A **ImageAdaptor** class will be created which will entend the BaseAdaptor class. This will connect the Gallery view with the images from ImageView views. 

**Fourth:** Use this code for the **ImageAdapter** class

```
  class ImageAdapter extends BaseAdapter
    {
    
     // TODO 1.1 Add Images to res/drawable to fill gallary.
        //TODO 1.2 Create array for images and grab images from drawable. Example below.
    
        //Array of images.
        public Integer[] images = {
                R.drawable.image1,
                R.drawable.image2,
                R.drawable.image3,
                R.drawable.image4,
                R.drawable.image5
        };
        
        private Context Mcontext;

       //Constructor
        public ImageAdapter(Context context) {

            Mcontext = context;
        }
        // MAJOR METHOD. Gets length of array.
        @Override
        public int getCount() {

            return images.length;
        }
        // MAJOR METHOD. Gets the data associated with the specified position in the list. 
        @Override
       public Object getItem(int pos) {

            return pos;
        }
        // MAJOR METHOD.. Returns the position within the adaptors data set.
        @Override
        public long getItemId(int pos) {

            return pos;
        }
        // MAJOR METHOD.. This allows the developer to inflate the view into the proper layout parameters.
        public View getView(int index, View view, ViewGroup viewGroup)
        {
            ImageView i = new ImageView(Mcontext);

            i.setImageResource(images[index]);
            // MAJOR COMPONENT.
            i.setLayoutParams(new Gallery.LayoutParams(200, 200));

            i.setScaleType(ImageView.ScaleType.FIT_XY);
            return i;
        }


   
    }

```
  
  The images array is used to grab all the images from the drawable directory. It allows these images to be used by ImageView and Gallery. 
  
  ![image of screen](https://github.com/lucasfini/Gallery/blob/master/images/screen.png)
  
## <a name="References"> References </a>

I have used a number of references for this assignment. Although I did use the code from the references, I made sure to use it in my own way and not copy it directly. 

[link to android developer!](https://developer.android.com/reference/android/widget/Gallery)

[link to Create Gallery in Android app!](http://www.exceptionbound.com/programming-tut/android-tutorial/create-gallery-in-android-using-android-studio)

[link to Android Gallery View Example Tutorial!](https://www.journaldev.com/9546/android-gallery-view-example-tutorial)

