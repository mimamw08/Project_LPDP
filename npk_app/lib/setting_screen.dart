import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';

class Setting_Screen extends StatelessWidget {
  const Setting_Screen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(
          "Settings",
          style: GoogleFonts.roboto(
              color: Colors.black, fontWeight: FontWeight.w700),
        ),
        backgroundColor: Color(0xffffffff),
        iconTheme: IconThemeData(color: Colors.black),
      ),
      body: Container(
        child: Container(
          padding: EdgeInsets.symmetric(vertical: 60),
          decoration: BoxDecoration(
            borderRadius: BorderRadius.all(Radius.circular(4)),
            color: Colors.white30,
            image: DecorationImage(
                image: AssetImage('assets/images/tanaman.png'),
                fit: BoxFit.cover,
                colorFilter: ColorFilter.mode(
                    Colors.black.withOpacity(0.2), BlendMode.dstATop)),
          ),
        ),
      ),
    );
  }
}
