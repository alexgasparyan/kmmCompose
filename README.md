# kmmCompose

This is a Kotlin Multiplatform project targeting Android, iOS. UI of the application is fully based on `Compose Multiplatform`.

* `/composeApp` contains the Android application, as well as the presentation layer of the application.
* `/sources` contains `data` and `domain` layers with their api/impl modules, as well as the `entity` module that is shared between `data` and `domain`.
* `/iosApp` contains the iOS application. Even if you’re sharing your UI with Compose Multiplatform, 
  you need this entry point for your iOS app. This is also where SwiftUI code should go if required.

## Limitations

This is the list of limitations that I encountered when building the project:

1. Multiplatform cannot use resources spread in different modules when building ios. It is a limitation of compose-resources library. 
For now, all should be in 1 module that is why presentation layer code has to be in a single module.