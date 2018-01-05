# Android Indefinite Pager Indicator

A lightweight, plug-and-play indefinite pager indicator for RecyclerViews &amp; ViewPagers.

![GIF Preview](https://github.com/rbro112/Android-Indefinite-Pager-Indicator/blob/master/readme_assets/preview.gif)

# Usage

 [ ![Download](https://api.bintray.com/packages/rbro112/maven/IndefinitePagerIndicator/images/download.svg?version=1.0.2) ](https://bintray.com/rbro112/maven/IndefinitePagerIndicator/1.0.2/link)

To use the IndefinitePagerIndicator, simply add the gradle dependency to your module's `build.gradle` file:

```groovy
compile 'com.ryanjeffreybrooks:indefinitepagerindicator:1.0.2'
```

## Getting Started

Attaching the indicator to a RecyclerView or Viewpager takes only one line of code. After this, the Indefinite Pager Indicator will handle everything else!

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



## Customizing

To customize

Customizable features:


// TODO: TABLE WITH EXPLANATION OF WHAT EACH ONE IS AND WHAT TYPE, ex + default + image

1. Dot radius
2. Selected dot radius
3. Dot color
4. Selected dot color
5. Dot separation distance (edge to edge)
6. Dot count
7. Fading dot count

| Attribute             | Explanation                                                                       | Default Value | Example Code                       |  Result  |
|-----------------------|-----------------------------------------------------------------------------------|---------------|------------------------------------|:--------:|
| dotRadius             | The radius of a dot indicator in DP.                                              | 4dp           | `app:dotRadius="8dp"`              |          |
| selectedDotRadius     | The radius of the currently selected dot indicator in DP.                         | 5.5dp         | `app:selectedDotRadius="8dp"`      |          |
| dotColor              | The color of a dot indicator.                                                     | #e8e8e8       | `app:dotColor="#ff0000"`           |          |
| selectedDotColor      | The color of the currently selected dot indicator.                                | #ffffff       | `app:selectedDotColor="#ff0000"`   |          |
| dotSeparationDistance | The distance from the edge of one dot to the starting edge of the next dot in DP. | 10dp          | `app:dotSeparationDistance="16dp"` |          |
| dotCount              | The number of large visible dot indicators at any time.                           | 5             | `app:dotCount="3"`                 |          |
| fadingDotCount        | The number of dot indicators that fade towards the edge.                          | 1             | `app:fadingDotCount="2"`           |          |

## TODO:

Actively working on these. If you would like to help, submit a PR!

"Instagram" style -- image


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
