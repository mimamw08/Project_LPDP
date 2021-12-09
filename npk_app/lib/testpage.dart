import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:npk_app/calculator_screen.dart';
import 'package:npk_app/history_screen.dart';
import 'package:npk_app/home_screen.dart';
import 'package:npk_app/meassure_screen.dart';
import 'package:npk_app/setting_screen.dart';
import 'package:npk_app/welcome_screen.dart';
import 'package:npk_app/Widget/customWidget.dart';

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
              onTap: () => Navigator.push(context,
                  MaterialPageRoute(builder: (context) => HomeScreen())),
            ),
            ListTile(
              leading: Icon(Icons.account_circle),
              title: Text(
                'Profile',
                style: GoogleFonts.roboto(
                    fontSize: 14, fontWeight: FontWeight.w500),
              ),
              onTap: () => Navigator.push(context,
                  MaterialPageRoute(builder: (context) => HomeScreen())),
            ),
            ListTile(
              leading: Icon(Icons.help),
              title: Text(
                'Help',
                style: GoogleFonts.roboto(
                    fontSize: 14, fontWeight: FontWeight.w500),
              ),
              onTap: () => Navigator.push(context,
                  MaterialPageRoute(builder: (context) => HomeScreen())),
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
                  MaterialPageRoute(builder: (context) => WelcomeScreen())),
            ),
          ],
        ),
      ),
      body: SingleChildScrollView(
        child: Container(
          padding: EdgeInsets.symmetric(vertical: 40),
          decoration: BoxDecoration(
            borderRadius: BorderRadius.all(Radius.circular(4)),
            color: Colors.white30,
            image: DecorationImage(
                image: AssetImage("assets/images/tanaman.png"),
                fit: BoxFit.cover,
                colorFilter: ColorFilter.mode(
                    Colors.black.withOpacity(0.2), BlendMode.dstATop)),
          ),
          child: Row(
            mainAxisAlignment: MainAxisAlignment.spaceAround,
            crossAxisAlignment: CrossAxisAlignment.start,
            children: <Widget>[
              SizedBox(
                height: 823,
                width: 0,
              ),
              buildBox(
                  child: Column(
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
                                  color: Colors.black,
                                )))
                      ],
                    ),
                  ),
                ],
              )),
              buildBox(
                  child: Column(
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
                        Image.asset('assets/icon/History_icon.png'),
                        RichText(
                            text: TextSpan(
                                text: "History",
                                style: GoogleFonts.roboto(
                                  fontSize: 16,
                                  color: Colors.black,
                                )))
                      ],
                    ),
                  )
                ],
              )),
              buildBox(
                  child: Column(
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
                                  color: Colors.black,
                                )))
                      ],
                    ),
                  )
                ],
              )),
              SizedBox(
                width: 5,
              ),
              Row(
                children: [
                  Container(
                      child: Column(
                    mainAxisAlignment: MainAxisAlignment.end,
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [Text("News")],
                  ))
                ],
              )
            ],
          ),
        ),
      ),
    );
  }
}
