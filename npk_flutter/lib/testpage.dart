import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:npk_flutter/components/news_card.dart';
import 'package:npk_flutter/calculator_screen.dart';
import 'package:npk_flutter/help_screen.dart';
import 'package:npk_flutter/history_screen.dart';
import 'package:npk_flutter/home_screen.dart';
import 'package:npk_flutter/meassure_screen.dart';
import 'package:npk_flutter/new_welcom_screen.dart';
import 'package:npk_flutter/setting_screen.dart';
import 'package:npk_flutter/welcome_screen.dart';
import 'package:npk_flutter/widget/customWidget.dart';

class TestPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        iconTheme: IconThemeData(color: Colors.black),
        backgroundColor: Color(0xffffffff),
      ),
      drawer: Drawer(
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
        padding: EdgeInsets.symmetric(horizontal: 8),
        decoration: BoxDecoration(
          borderRadius: BorderRadius.all(Radius.circular(4)),
          image: DecorationImage(
              image: AssetImage('assets/images/tanaman.png'),
              fit: BoxFit.cover,
              colorFilter: ColorFilter.mode(
                  Colors.black.withOpacity(0.2), BlendMode.dstATop)),
        ),
        child: ListView(
          children: [
            SizedBox(
              height: 40,
            ),
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceAround,
              children: <Widget>[
                box1(
                    child: Row(
                  children: [
                    GestureDetector(
                      onTap: () {
                        Navigator.push(
                            context,
                            MaterialPageRoute(
                                builder: (context) => Meassure_Screen()));
                      },
                      child: Column(
                        children: [
                          Image.asset('assets/icon/Meassure_Icon.png'),
                          RichText(
                              text: TextSpan(
                            text: "Meassure",
                            style: GoogleFonts.roboto(
                                fontSize: 16,
                                fontWeight: FontWeight.w500,
                                color: Colors.black),
                          ))
                        ],
                      ),
                    )
                  ],
                )),
                box2(
                    child: Row(
                  children: [
                    GestureDetector(
                      onTap: () {
                        Navigator.push(
                            context,
                            MaterialPageRoute(
                                builder: (context) => History_Screen()));
                      },
                      child: Column(
                        children: [
                          SizedBox(
                            height: 1,
                          ),
                          Center(
                            child: Container(
                              child: Align(
                                alignment: Alignment.bottomCenter,
                                child: Column(
                                  children: [
                                    Image(
                                        image: AssetImage(
                                            'assets/icon/History_icon.png')),
                                    Text(
                                      "History",
                                      style: GoogleFonts.roboto(
                                          fontSize: 16,
                                          fontWeight: FontWeight.w500,
                                          color: Colors.black),
                                    )
                                  ],
                                ),
                              ),
                            ),
                          ),
                          // Image.asset('assets/icon/History_icon.png'),
                          // RichText(
                          //     text: TextSpan(
                          //   text: "History",
                          //   style: GoogleFonts.roboto(
                          //       fontSize: 16,
                          //       fontWeight: FontWeight.w500,
                          //       color: Colors.black),
                          // ))
                        ],
                      ),
                    )
                  ],
                )),
                box3(
                    child: Row(
                  children: [
                    GestureDetector(
                      onTap: () {
                        Navigator.push(
                            context,
                            MaterialPageRoute(
                                builder: (context) => Calculator_Screen()));
                      },
                      child: Column(
                        children: [
                          Image.asset('assets/icon/Calculator_icon.png'),
                          RichText(
                              text: TextSpan(
                            text: "Calculator",
                            style: GoogleFonts.roboto(
                                fontSize: 16,
                                fontWeight: FontWeight.w500,
                                color: Colors.black),
                          ))
                        ],
                      ),
                    )
                  ],
                )),
              ],
            ),
            Align(
              alignment: Alignment(-0.8, 0.1),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.end,
                children: [
                  SizedBox(
                    height: 30,
                  ),
                  Text(
                    "NEWS",
                    style: GoogleFonts.roboto(
                        fontSize: 26, fontWeight: FontWeight.w600),
                  )
                ],
              ),
            ),
            SizedBox(
              height: 30,
            ),
            buildBox(
                child: Column(
              children: [
                Newscard(),
                Newscard(),
                Newscard(),
              ],
            )),
          ],
        ),
      ),
    );
  }
}
