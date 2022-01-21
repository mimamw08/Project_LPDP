import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:npk_flutter/meassure_screen_npk_p201.dart';
import 'package:npk_flutter/new_welcom_screen.dart';
import 'package:npk_flutter/testpage.dart';
import 'package:npk_flutter/setting_screen.dart';
import 'package:npk_flutter/welcome_screen.dart';

class Help_Screen extends StatelessWidget {
  const Help_Screen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        iconTheme: IconThemeData(color: Colors.black),
        backgroundColor: Color(0xffffffff),
        title: Text(
          "Help",
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
              onTap: () => Navigator.push(
                  context, MaterialPageRoute(builder: (context) => TestPage())),
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
      ),
    );
  }
}
