# date-time-picker

### Library for Custom [`date time picker`](https://github.com/dasBikash84/date-time-picker/blob/master/date-time-picker/src/main/java/com/dasbikash/date_time_picker/DateTimePicker.kt) view on android.
[![](https://jitpack.io/v/dasBikash84/date-time-picker.svg)](https://jitpack.io/#dasBikash84/date-time-picker)

## Dependency

Add this in your root `build.gradle` file (**not** your module `build.gradle` file):

```gradle
allprojects {
	repositories {
        maven { url "https://jitpack.io" }
    }
}
```

Then, add the library to your module `build.gradle`
```gradle
dependencies {
    implementation 'com.github.dasBikash84:date-time-picker:latest.release.here'
}
```
## Usage example

##### Calling from activity
```
    val dateTimePicker = DateTimePicker(date = Date(),doOnDateTimeSet = {println(it)})
    dateTimePicker.display(this)
```

##### Calling from fragment
```
    val dateTimePicker = DateTimePicker(date = Date(),doOnDateTimeSet = {println(it)})
    dateTimePicker.display(context!!)
```
License
--------

    Copyright 2020 Bikash Das(das.bikash.dev@gmail.com)

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
