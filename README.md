# Gallery

## Introduction

The android Gallery is a View that shows items in a center-locked, horizontally scrolling list. Although it isn't used anymore, when it was available it allowed users to view photos one at a time, in a organized manner. It uses the interface **Adapter** to populate items to the Gallery. The Adaptor class etends **BaseAdaptor** class and overrides the **getView()** method. It is responsible for making a View for each item in the data set. The **getView()** method uses **Gallery.LayoutParams** as its layout parameters type.

## History

This component was introduced in **API level 1** and was Deprecated in **API level 16**. Since the widget is no longer supported, some great alternatives are: **HorizontalScrollView** and **ViewPager**. It belongs to the **android.widget.Gallery** class and was included in the **android.view.View** package library.

![image of packages](https://github.com/lucasfini/Gallery/blob/master/images/Screen%20Shot%202019-11-30%20at%206.07.46%20PM.png)

## Major Methods/Components. 

**getCount()** Gets the length of the array 
**getItem()** Gets the data associated with the specified position in the list.
**getItemId()** Returns the position within the adaptors data set.
**getView()** This allows the developer to inflate the view into the proper layout parameters.
**onItemClick** This allows a user to click/drag on an image, and get a response in return. 
**.setLayoutParams** Uses **Gallery.LayoutParams** to set the size of the images in ImageView. 

## Example Project and Code.




