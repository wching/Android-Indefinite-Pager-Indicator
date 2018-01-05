# Android Indefinite Pager Indicator

A lightweight, plug-and-play indefinite pager indicator for RecyclerViews &amp; ViewPagers.

![GIF Preview](/readme_assets/preview.gif)

# Usage

 [ ![Download](https://api.bintray.com/packages/rbro112/maven/IndefinitePagerIndicator/images/download.svg?version=1.0.2) ](https://bintray.com/rbro112/maven/IndefinitePagerIndicator/1.0.2/link)

To use the IndefinitePagerIndicator, simply add the gradle dependency to your module's `build.gradle` file:

```groovy
compile 'com.ryanjeffreybrooks:indefinitepagerindicator:1.0.2'
```

## Getting Started

Attaching the indicator to a RecyclerView or Viewpager takes only one line of code. After this, the Indefinite Pager Indicator will handle everything else.

### RecyclerView

1. Add the IndefinitePagerIndicator view to your XML file

```xml
<com.rbrooks.indefinitepagerindicator.IndefinitePagerIndicator
        android:id="@+id/recyclerview_pager_indicator"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        ... 
        />
```

2. Find the view in your activity, fragment, etc.

```java
findViewById(R.id.recyclerview_pager_indicator);
```

3. Attach the RecyclerView to your IndefinitePagerIndicator

```java
indefinitePagerIndicator.attachToRecyclerView(recyclerView);
```

That's it! The IndefinitePagerIndicator will handle updating as your RecyclerView does.

### ViewPager

1. Add the IndefinitePagerIndicator view to your XML file


```xml
<com.rbrooks.indefinitepagerindicator.IndefinitePagerIndicator
        android:id="@+id/viewpager_pager_indicator"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        ... 
        />
```

2. Find the view in your activity, fragment, etc.
   
```java
findViewById(R.id.viewpager_pager_indicator);
```

3. Attach the RecyclerView to your IndefinitePagerIndicator

```java
indefinitePagerIndicator.attachToViewPager(viewPager);
```

That's it! The IndefinitePagerIndicator will handle updating as your ViewPager does.

The position of the ViewPager can also be changed programmatically with `viewPager.setCurrentItem(position)` and the IndefinitePagerIndicator will update successfully.

### Sample

A sample application is included in the repository. To view the sample:

1. Clone the repository locally
```shell
git clone git@github.com:rbro112/Android-Indefinite-Pager-Indicator.git
```

2. Build and run the sample module.

![Alt text](/readme_assets/run_sample.png "run sample")


## Customizing

To customize the IndefinitePagerIndicator, modify any of the following attributes in the XML code for your IndefinitePagerIndicator view.

| Attribute             | Explanation                                               | Default Value | Example Code                     |  Result  |
|-----------------------|-----------------------------------------------------------|---------------|----------------------------------|:--------:|
| dotRadius             | The radius of a dot indicator in DP.                      | 4dp           | `app:dotRadius="8dp"`            |     ![Alt text](/readme_assets/dot_radius_sample.png "dotRadius")     |
| selectedDotRadius     | The radius of the currently selected dot indicator in DP. | 5.5dp         | `app:selectedDotRadius="6dp"`    |     ![Alt text](/readme_assets/selected_dot_radius_sample.png "selectedDotRadius")     |
| dotColor              | The color of a dot indicator.                             | #e8e8e8       | `app:dotColor="#ff0000"`         |     ![Alt text](/readme_assets/dot_color_sample.png "dotColor")     |
| selectedDotColor      | The color of the currently selected dot indicator.        | #ffffff       | `app:selectedDotColor="#ff0000"` |     ![Alt text](/readme_assets/selected_dot_color_sample.png "selectedDotColor")     |
| dotSeparation         | The distance from edge to edge of each dot in DP.         | 10dp          | `app:dotSeparation="16dp"`       |     ![Alt text](/readme_assets/dot_separation_sample.png "dotSeparation")     |
| dotCount              | The number of large visible dot indicators at any time.   | 5             | `app:dotCount="3"`               |     ![Alt text](/readme_assets/dot_count_sample.png "dotCount")     |
| fadingDotCount        | The number of dot indicators that fade towards the edge.  | 1             | `app:fadingDotCount="2"`         |     ![Alt text](/readme_assets/fading_dot_count_sample.png "fadingDotCount")     |

## TODO:

Actively working on these. If you would like to help, submit a PR!

"Instagram" style -- Selected dot starts at the left of the view rather than starting in the center.


## Notes

Follow me on Twitter: [@rbro112](https://twitter.com/rbro112)

Let me know what you think: [ryanjeffrey.brooks112@gmail.com](mailto:ryanjeffrey.brooks112@gmail.com)

Contributions welcome!

## License
```
MIT License

Copyright (c) 2017 Ryan Brooks

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
