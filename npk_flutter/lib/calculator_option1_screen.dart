import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:npk_flutter/Components/calculator_card.dart';
import 'package:npk_flutter/Components/meassure_card.dart';
import 'package:npk_flutter/Widget/customWidget.dart';
import 'package:npk_flutter/calculator_screen.dart';
import 'package:npk_flutter/help_screen.dart';
import 'package:npk_flutter/home_screen.dart';
import 'package:npk_flutter/meassure_screen.dart';
import 'package:npk_flutter/my_data_screen.dart';
import 'package:npk_flutter/new_welcom_screen.dart';
import 'package:npk_flutter/setting_screen.dart';
import 'package:npk_flutter/testpage.dart';
import 'package:npk_flutter/welcome_screen.dart';

class Calculator_Option1 extends StatelessWidget {
  const Calculator_Option1({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        iconTheme: IconThemeData(color: Colors.black),
        backgroundColor: Color(0xffffffff),
        title: Text(
          "Calculator",
          style: TextStyle(color: Colors.black, fontWeight: FontWeight.w700),
        ),
        leading: GestureDetector(
          onTap: () {
            Navigator.push(context,
                MaterialPageRoute(builder: (context) => Calculator_Screen()));
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
            Column(
              children: [
                SizedBox(
                  height: 40,
                ),
                Column(
                  children: [
                    buildBox(
                      child: Column(
                        children: [
                          CalculatorCard(),
                          SizedBox(
                            height: 10,
                          ),
                          GestureDetector(
                            onTap: () {
                              Navigator.push(
                                  context,
                                  MaterialPageRoute(
                                      builder: (context) => Meassure_Screen()));
                            },
                            child: Card(
                              child: ListTile(
                                leading: ConstrainedBox(
                                  constraints: BoxConstraints(
                                      // minWidth: 44,
                                      // minHeight: 44,
                                      // maxWidth: 64,
                                      // maxHeight: 64,
                                      ),
                                  child: Image.asset(
                                      'assets/icon/tabung_kimia.png',
                                      fit: BoxFit.cover),
                                ),
                                title: Text(
                                  "Fertilizer PPM Calculator",
                                  style: GoogleFonts.roboto(
                                    fontSize: 15,
                                    fontWeight: FontWeight.w500,
                                    color: Colors.white,
                                  ),
                                ),
                              ),
                              elevation: 2,
                              color: Colors.green,
                              margin: EdgeInsets.all(20),
                            ),
                          ),
                          Align(
                            alignment: Alignment.centerLeft,
                            child: Text(
                              "N // Urea",
                              style: GoogleFonts.roboto(
                                  fontSize: 16,
                                  fontWeight: FontWeight.w500,
                                  color: Colors.black),
                            ),
                          ),
                          SizedBox(
                            height: 10,
                          ),
                          TextField(
                            obscureText: false,
                            decoration: InputDecoration(
                              border: InputBorder.none,
                              fillColor: Color(0xfff3f3f4),
                              filled: true,
                            ),
                          ),
                          Align(
                            alignment: Alignment.centerLeft,
                            child: Text(
                              "P // P205 // SP-36",
                              style: GoogleFonts.roboto(
                                  fontSize: 16,
                                  fontWeight: FontWeight.w500,
                                  color: Colors.black),
                            ),
                          ),
                          SizedBox(
                            height: 10,
                          ),
                          TextField(
                            obscureText: false,
                            decoration: InputDecoration(
                              border: InputBorder.none,
                              fillColor: Color(0xfff3f3f4),
                              filled: true,
                            ),
                          ),
                          Align(
                            alignment: Alignment.centerLeft,
                            child: Text(
                              "K // K2O // KCL",
                              style: GoogleFonts.roboto(
                                  fontSize: 16,
                                  fontWeight: FontWeight.w500,
                                  color: Colors.black),
                            ),
                          ),
                          SizedBox(
                            height: 10,
                          ),
                          TextField(
                            obscureText: false,
                            decoration: InputDecoration(
                              border: InputBorder.none,
                              fillColor: Color(0xfff3f3f4),
                              filled: true,
                            ),
                          ),
                          SizedBox(
                            height: 35,
                          ),
                          GestureDetector(
                            onTap: () {
                              Navigator.pop(context, true);
                            },
                            child: Container(
                              width: MediaQuery.of(context).size.width,
                              padding: EdgeInsets.symmetric(vertical: 10),
                              alignment: Alignment.center,
                              decoration: BoxDecoration(
                                borderRadius:
                                    BorderRadius.all(Radius.circular(11)),
                                boxShadow: <BoxShadow>[
                                  BoxShadow(
                                    color: Colors.grey.shade200,
                                    offset: Offset(2, 4),
                                    blurRadius: 5,
                                    spreadRadius: 2,
                                  ),
                                ],
                                gradient: LinearGradient(
                                  begin: Alignment.centerLeft,
                                  end: Alignment.centerRight,
                                  colors: [
                                    Color(0xff55A851),
                                    Color(0xff55A851),
                                  ],
                                ),
                              ),
                              child: Text(
                                'Submit',
                                style: TextStyle(
                                    fontSize: 20, color: Colors.white),
                              ),
                            ),
                          ),
                        ],
                      ),
                    ),
                  ],
                ),
              ],
            ),
          ],
        ),
      ),
    );
  }
}
