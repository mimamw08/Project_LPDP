import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:npk_flutter/Components/calculator_card.dart';
import 'package:npk_flutter/help_screen.dart';
import 'package:npk_flutter/home_screen.dart';
import 'package:npk_flutter/new_welcom_screen.dart';
import 'package:npk_flutter/setting_screen.dart';
import 'package:npk_flutter/testpage.dart';
import 'package:npk_flutter/welcome_screen.dart';
import 'package:npk_flutter/Widget/customWidget.dart';

class Setting_Screen extends StatelessWidget {
  const Setting_Screen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        iconTheme: IconThemeData(color: Colors.black),
        backgroundColor: Color(0xffffffff),
        title: Text(
          "Setting",
          style: TextStyle(color: Colors.black, fontWeight: FontWeight.w700),
        ),
        leading: GestureDetector(
          onTap: () {
            Navigator.push(
                context, MaterialPageRoute(builder: (context) => TestPage()));
          },
          child: Icon(Icons.arrow_back),
        ),
        // actions: <Widget>[
        //   IconButton(
        //     icon: Icon(
        //       Icons.keyboard_arrow_left,
        //       color: Colors.black,
        //     ),
        //     onPressed: () {
        //       Navigator.push(
        //           context, MaterialPageRoute(builder: (context) => TestPage()));
        //     },
        //   )
        // ],
      ),
      endDrawer: Drawer(
        child: ListView(
          padding: EdgeInsets.zero,
          children: <Widget>[
            DrawerHeader(
              decoration: BoxDecoration(
                image: DecorationImage(
                  image: AssetImage("assets/images/tanaman2.png"),
                  fit: BoxFit.cover,
                ),
                //color: Colors.green,
              ),
              child: Text(
                'Rahmad Darmawan',
                textAlign: TextAlign.left,
                style: TextStyle(
                  height: 10,
                  color: Colors.white,
                  fontSize: 14,
                ),
              ),
            ),
            ListTile(
              leading: Icon(Icons.home),
              title: Text(
                'Home',
                style: GoogleFonts.roboto(
                    fontSize: 14, fontWeight: FontWeight.w500),
              ),
              onTap: () => Navigator.push(
                  context, MaterialPageRoute(builder: (context) => TestPage())),
            ),
            ListTile(
              leading: Icon(Icons.account_circle),
              title: Text(
                'Profile',
                style: GoogleFonts.roboto(
                    fontSize: 14, fontWeight: FontWeight.w500),
              ),
              onTap: () => Navigator.push(context,
                  MaterialPageRoute(builder: (context) => Setting_Screen())),
            ),
            ListTile(
              leading: Icon(Icons.help),
              title: Text(
                'Help',
                style: GoogleFonts.roboto(
                    fontSize: 14, fontWeight: FontWeight.w500),
              ),
              onTap: () => Navigator.push(context,
                  MaterialPageRoute(builder: (context) => Help_Screen())),
            ),
            ListTile(
              leading: Icon(Icons.settings),
              title: Text('Settings',
                  style: GoogleFonts.roboto(
                      fontSize: 14, fontWeight: FontWeight.w500)),
              onTap: () => Navigator.push(context,
                  MaterialPageRoute(builder: (context) => Setting_Screen())),
            ),
            ListTile(
              leading: const Icon(Icons.logout),
              title: Text('Log Out',
                  style: GoogleFonts.roboto(
                      fontSize: 14, fontWeight: FontWeight.w500)),
              onTap: () => Navigator.push(context,
                  MaterialPageRoute(builder: (context) => welcome_screen())),
            ),
          ],
        ),
      ),
      body: Container(
        decoration: BoxDecoration(
          borderRadius: BorderRadius.all(Radius.circular(4)),
          image: DecorationImage(
              image: AssetImage('assets/images/tanaman.png'),
              fit: BoxFit.cover,
              colorFilter: ColorFilter.mode(
                  Colors.black.withOpacity(0.2), BlendMode.dstATop)),
        ),
        child: Container(
          padding: EdgeInsets.symmetric(vertical: 40, horizontal: 10),
          child: Column(
            children: [
              Align(
                alignment: Alignment(-0.8, 1.0),
                child: Text(
                  "My Profile",
                  style: GoogleFonts.roboto(
                      fontSize: 18,
                      fontWeight: FontWeight.w700,
                      color: Colors.green),
                ),
              ),
              SizedBox(
                height: 10,
              ),
              buildBox(
                  child: Row(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: [
                  Column(
                    children: [
                      CircleAvatar(
                        radius: 40,
                        backgroundImage:
                            AssetImage('assets/images/tanaman2.png'),
                      ),
                    ],
                  ),
                  Column(
                    crossAxisAlignment: CrossAxisAlignment.end,
                    mainAxisAlignment: MainAxisAlignment.start,
                    children: [
                      Align(
                        child: RichText(
                          text: TextSpan(
                            text: 'Lorem Ipsum',
                            style: GoogleFonts.roboto(
                                fontSize: 15,
                                fontWeight: FontWeight.w700,
                                color: Colors.green),
                          ),
                          textAlign: TextAlign.left,
                        ),
                      ),
                    ],
                  ),
                  GestureDetector(
                      onTap: () {
                        Navigator.pop(context, true);
                      },
                      child: Icon(
                        Icons.edit,
                        color: Colors.green,
                      ))
                ],
              )),
              SizedBox(
                height: 15,
              ),
              Align(
                alignment: Alignment(-0.8, 1.0),
                child: Text(
                  "Settings",
                  style: GoogleFonts.roboto(
                      fontSize: 18,
                      fontWeight: FontWeight.w700,
                      color: Colors.green),
                ),
              ),
              SizedBox(
                height: 10,
              ),
              buildBox(
                child: Column(
                  children: [
                    SizedBox(
                      height: 10,
                    ),
                    Align(
                      alignment: Alignment.centerLeft,
                      child: Column(
                        children: [],
                      ),
                    ),
                    ListTile(
                      leading: Icon(Icons.language),
                      title: Text(
                        'Language',
                        style: GoogleFonts.roboto(
                            fontSize: 14, fontWeight: FontWeight.w500),
                      ),
                      onTap: () {
                        Navigator.pop(context, true);
                      },
                    ),
                    ListTile(
                      leading: Icon(Icons.notifications),
                      title: Text(
                        'Notification',
                        style: GoogleFonts.roboto(
                            fontSize: 14, fontWeight: FontWeight.w500),
                      ),
                      onTap: () {
                        Navigator.pop(context, true);
                      },
                    ),
                    ListTile(
                      leading: Icon(Icons.lock),
                      title: Text(
                        'Change Password',
                        style: GoogleFonts.roboto(
                            fontSize: 14, fontWeight: FontWeight.w500),
                      ),
                      onTap: () {
                        Navigator.pop(context, true);
                      },
                    ),
                    ListTile(
                      leading: Icon(Icons.help_center_outlined),
                      title: Text('About',
                          style: GoogleFonts.roboto(
                              fontSize: 14, fontWeight: FontWeight.w500)),
                      onTap: () {
                        Navigator.pop(context, true);
                      },
                    ),
                    ListTile(
                      leading: const Icon(Icons.logout),
                      title: Text('Log Out',
                          style: GoogleFonts.roboto(
                              fontSize: 14, fontWeight: FontWeight.w500)),
                      onTap: () => Navigator.push(
                          context,
                          MaterialPageRoute(
                              builder: (context) => WelcomeScreen())),
                    ),
                  ],
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
