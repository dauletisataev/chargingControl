# Charging Control
Charging control is IoT device that controls the process of charging of the smartphone. This device seek to avoid battery explosions in a night charging. Also, by this approach the lifetime of the battery is expanded.
#### Three mode of charging were deployed in this app:
  - ***Regular mode***
    In this mode the phone will be disconnected from charging when it is fully charged.
  - ***Timer mode***
    Device will stop charging in a time set by user.
  - ***Effective mode***
    In this mode the controller will charge the battery by the recommended approach which reduces the charge cycles and damage to the battery.
    So, before the set time the device will be held in a range of 20%-80%.
    In the graph below it can be seen how the level of battery charge changes during the charge time.
    ![](https://firebasestorage.googleapis.com/v0/b/nu-schedule.appspot.com/o/effectiveMode.png?alt=media&token=1620f700-3f22-47c8-87d7-2b325d485a00)

# From prototypes to a working device
  - Initially, we had a huge device that uses the relay
  - Then, decreased the size three times using transistors
  ![](https://firebasestorage.googleapis.com/v0/b/nu-schedule.appspot.com/o/1.2.png?alt=media&token=132b78a7-c572-43d3-a61b-b96a99f3fb9a)


>The application communicates with the device through the bluetooth
>According to the received signal the device will turn on or off the charging process.
![](https://firebasestorage.googleapis.com/v0/b/nu-schedule.appspot.com/o/%D1%81%D1%85%D0%B5%D0%BC%D0%B0.png?alt=media&token=bedf63c3-51a6-44ae-af97-9d2571f6899b)
