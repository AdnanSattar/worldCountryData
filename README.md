# World Country Flags - an open source android library for getting country flags
[![](https://jitpack.io/v/blongho/world-country-flags.svg)](https://jitpack.io/#blongho/world-country-flags)

An Android library that contains 'all' the flags of the countries of the world
This is to be used for android projects where the developer is interested in getting
the flag of a particular country for any reason.

- A country flag is obtained as a drawable resource id.
- There is possibility to get all the countries and their flags by calling just two methods.

## System requirement
- Android minSDKversion = 15
- Android targetSDKversion = 28


## Usage
1. Add JitPack in your respository build file `build.gradle`
```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

2. Get the latest release from the master branch by including
```
dependencies {
    ...
    implementation 'com.github.blongho:world-country-flags:master-SNAPSHOT'
}
```
Replace `master-SNAPSHOT` with `vXXX` for the version you want to use
see [releases](https://github.com/blongho/world-country-flags/releases))

3. Build your project (and make sure gradle has successfully synced)

4. Load all the flags of the world by calling. Do this once in the context.
```
CountryFlagUtility.init(getApplication());
```
This inititializes the data. All countries are read, and their flags loaded

5. Get the flag of a country
You can get the flag of a country by using the two iso alpha2 or alpha3 or the country name or the numeric code.

```
// Demonstrating with Sweden
The attribute is case-insensitive "se == SE == sE == Se"

// use alpha2
final int flag = CountryFlagUtility.getFlagOf("se"); // use "se" or "sE" or "SE" or "Se"

// use alpha3
final int flag = CountryFlagUtility.getFlagOf("swe");

// Use country name
final int flag = CountryFlagUtility.getFlagOf("sweden");

// final int flag = CountryFlagUtility.getFlagOf(752);

// Set the image of an imageView
final ImageView swedishFlag= (ImageView) findViewById(R.id.flagImageView);
swedishFlag.setImageResource(flag);

// The value of flag is either
- the flag of the country if it is loaded in the library
OR
- a demo flag of the globe (This provides a fall-back and help your app not crash due to nullPointerException)
```
6. Get a Country with like `"id":4,"name":"Afghanistan","alpha2":"af","alpha3":"afg", flag:imageResource"`
```
final Country sweden = CountryFlagUtility.getCountryFrom("se|swe|sweden|752");
```

7. Get a list of all the countries with their identifies
```
final List<Country> countries = CountryFlagUtility.getAllCountries();
// countries cannot be modified but you can get its contents
```	
## Data sources for the project

### All country flags
Most of the flags came from [flagpedia.net](http://flagpedia.net/download).
This site does not contain all the countries in the world so some where downloaded
from [wikipedia](https://www.wikipedia.org/) after quering the country name

### Countries and their iso alpha values
All country names were download from
[GitHub@stafangabos](https://github.com/stefangabos/world_countries/tree/master/data/en).
These were copied using into the assets directory

### Getting different dimensions of the flags
Some guys from Egypt made some awesome [App icon generator](https://appicon.co/#image-sets)
which generates android drawables as well as iOS images(if you want) in different dimensions.
It is supperfast and can do batch processing of images.
Please consider [buying them a cup of coffee](https://www.buymeacoffee.com/appiconco) if you find this library useful.

## Contribution guidelines
Please feel free to add more flags or modify any thing that would make this libray more useful.
Follow [First contributions instructions](https://github.com/blongho/first-contributions/blob/master/README.md)
and i will be super happy to merge your pull request.


If you are particularly generous and want to reward this work, you can
[![](https://www.buymeacoffee.com/assets/img/custom_images/purple_img.png)](https://www.buymeacoffee.com/lKmSQRsaU)


## Next steps
Make this library available for web usage where one get same ease of use using different programming languages


## Contact
Feel free to [contact me](mailto:blongho02@gmail.com) to discuss anything related to development in particular and life in general.


## License
[MIT License](LICENSE.txt) <br>
Copyright (c) 2019 Bernard Longho
