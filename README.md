
# Farming Addons 1.8.9

This farming mod does add a few addons to enhance farming experience (by not doing anything). Made for Hypixel Skyblock.

## Compiling your own .jar

To compile this mod by your own, first download it's source code.

- Once you have the mod source code, place it in a folder, and open command line prompt in the folder.

- Use the command below to build the project:
```bash
  gradlew build
```

For Mac users:

```bash
  ./gradlew build
```

- You will have your playable version inside **/build/libs** folder

## Features

- Camera rotation command for perfect angles
- Rotation presets to classify by name

## How to use and command guidelines

| Command   | Parameters| Description                |
| :-------- | :------- | :------------------------- |
| `fahelp` | - | shows useful information about commands |
| `faconfig` | - | shows useful information about config management |
| `presetlist` | - | shows all saved presets |
| `rotate` | `horizontalNumber , verticalNumber` | rotates camera to the position given |
| `rotate` | `presetName` | rotates camera to the preset saved |
| `savepreset` | `name horizontalNumber verticalNumber` | saves preset with specified name |

### Help command

```bash
  /fahelp
```

Shows command guides and how to use them.

### Config command

```bash
  /faconfig
```

Shows command guides and how to use config manager.

### Rotate command

Using following screenshot, this command uses the numbers between brackets to set your camera position

![alt text](https://i.imgur.com/r17bZCZ.png)

- horizontalNumber : **6.9**
- verticalNumber : **37.5**

```bash
  /rotate <horizontalNumber> <verticalNumber>
```

Rotates to the position given, for example: **/rotate 90 0**

![alt text](https://i.imgur.com/tVX1Xr6.png)

```bash
  /rotate <name>
```
Rotates to the preset given, for example: **/rotate melon**
(see below to create presets)

### Preset command

```bash
  /savepreset <name> <horizontalNumber> <verticalNumber>
```

For example : **/savepreset melon 90 30**

so you can do **/rotate melon** later and be (90.0 / 30.0) 

## TODO

- Left Click toggle key
- Toggle W option