package com.n01229590.gallery;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;

// TODO Implement these imports
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


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

        //Moves Images to the bottom.
        ims.setY(1550);


        //Spacing between images.
        ims.setSpacing(2);

        // TODO 1.4 Create ImageAdaptor class which extends BaseAdaptor. This will work as a bridge between AdapterView and the data source that gets imputed.
        final ImageAdapter gImageAdapter= new ImageAdapter(this);
        ims.setAdapter(gImageAdapter);

       // TODO 1.5 This will allow a user to click on an image, and for response to happen.
        ims.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                // Tells the user what image they are on.
                Toast.makeText(getApplicationContext(), "Image " + position, Toast.LENGTH_SHORT).show();
                // show the selected Image
                sImage.setImageResource(gImageAdapter.images[position]);

            }
        });
    }
}


// TODO 1.4.1 Fill ImageAdaptor Class with these methods: getCount(), getItem(), getItemId(), getView.
    class ImageAdapter extends BaseAdapter
    {
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
        // Gets length of array.
        @Override
        public int getCount() {

            return images.length;
        }
        // Gets the data associated with the specified position in the list.
        @Override
        public Object getItem(int pos) {

            return pos;
        }
        // Returns the position within the adaptors data set.
        @Override
        public long getItemId(int pos) {

            return pos;
        }
        // This allows the developer to inflate the view into the proper layout parameters.
        public View getView(int index, View view, ViewGroup viewGroup)
        {
            ImageView placeI = new ImageView(Mcontext);
            placeI.setImageResource(images[index]);
            placeI.setLayoutParams(new Gallery.LayoutParams(225, 225));
            placeI.setScaleType(ImageView.ScaleType.FIT_XY);


            return placeI;

        }
        // TODO 1.1 Add Images to res/drawable to fill gallary.
        //TODO 1.2 Create array for images and grab images from drawable. Example below.


    }

