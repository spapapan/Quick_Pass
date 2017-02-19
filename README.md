# Quick_Pass
<i>Password manager to quickly pass authentication forms, written in Java.</i>


Quick Pass is a useful tool for anyone who wants to have strong passwords without the need to remember them and typing them when needed.

<b><i>HOW TO USE:</i></b>

To use Quick Pass just write your username and select it, then use the Hotkey <b>CTRL</b>+<b>C</b>+<b>SHIFT</b>. If there is no password
for the given username in the database it will create a new 20 character long password and place it in the clipboard so you can paste it wherever
you want.
If there is a password for the given username in the database, then it will automatically place the password in the clipboard.

Quick Pass is a program that runs in the background and has been tested only in <b>Windows</b>. At the right bottom corner of Windows there is
an icon of the program. If you right click it you will have 3 options: 

<b>Add Password:</b> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Manually add a username - password combination to the database. </br>
<b>Export Passwords:</b> &nbsp;Creates a text file with all the usernames - passwords combinations to a given path. </br>
<b>Exit:</b> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Terminates the application.

There is a java file with the name Encryption.java where you can add your own encryption and decryption algorithm so you can safely place the 
passwords in your local system.

<b>EXTERNAL LIBRARIES:</b>

To catch the Hotkey I used the library <a href="https://github.com/kwhat/jnativehook">jnativehook</a>.
