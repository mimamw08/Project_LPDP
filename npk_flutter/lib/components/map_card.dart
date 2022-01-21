import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';

class MapCard extends StatelessWidget {
  const MapCard({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Card(
      child: Container(
        child: Container(
            height: 115,
            decoration: BoxDecoration(
              borderRadius: BorderRadius.all(Radius.circular(24)),
              image: DecorationImage(
                image: AssetImage("assets/images/map.png"),
                fit: BoxFit.cover,
                colorFilter: ColorFilter.mode(
                    Colors.black.withOpacity(0.1), BlendMode.darken),
                alignment: Alignment.center,
              ),
            ),
            alignment: Alignment.center,
            child: Column(
              children: <Widget>[
                SizedBox(
                  height: 20,
                ),
              ],
            )),
      ),
    );
  }
}
