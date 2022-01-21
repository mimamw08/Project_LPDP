import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:npk_flutter/help_screen.dart';
import 'package:npk_flutter/history_screen.dart';
import 'package:npk_flutter/meassure_screen.dart';
import 'package:npk_flutter/my_data_screen.dart';
import 'package:npk_flutter/new_welcom_screen.dart';
import 'package:npk_flutter/testpage.dart';
import 'package:npk_flutter/welcome_screen.dart';
import 'package:npk_flutter/setting_screen.dart';
import 'package:google_maps_flutter/google_maps_flutter.dart';
import 'dart:async';

class Map_Screen extends StatelessWidget {
  const Map_Screen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        iconTheme: IconThemeData(color: Colors.black),
        backgroundColor: Color(0xffffffff),
        title: Text(
          "Map",
          style: TextStyle(color: Colors.black, fontWeight: FontWeight.w700),
        ),
        leading: GestureDetector(
          onTap: () {
            Navigator.push(context,
                MaterialPageRoute(builder: (context) => Mydata_Screen_p201()));
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
              image: DecorationImage(
                  image: AssetImage('assets/images/dummy_map.png'),
                  fit: BoxFit.cover))),
    );
  }
}

class map_screen extends StatefulWidget {
  map_screen({Key? key}) : super(key: key);

  @override
  _map_screenState createState() => _map_screenState();
}

class _map_screenState extends State<map_screen> {
  Completer<GoogleMapController> _controller = Completer();

  static final CameraPosition _kGooglePlex = CameraPosition(
    target: LatLng(-6.973007, 107.6294967),
    zoom: 15,
  );

  static final CameraPosition _kLake = CameraPosition(
      bearing: 192.8334901395799,
      target: LatLng(-6.973007, 107.6294967),
      tilt: 59.440717697143555,
      zoom: 19.151926040649414);
  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      appBar: AppBar(
        // title: Text(
        //   "",
        //   style: TextStyle(color: Colors.white),
        // ),
        backgroundColor: Colors.transparent,
        leading: GestureDetector(
          child: Icon(
            Icons.arrow_back,
            color: Colors.greenAccent,
          ),
          onTap: () {
            Navigator.push(context,
                MaterialPageRoute(builder: (context) => Mydata_Screen_p201()));
          },
        ),

        //elevation: 1,
        actions: [
          // Icon(
          //   Icons.contact_support_rounded,
          //   color: Colors.greenAccent,
          // ),
          GestureDetector(
            child:
                Icon(Icons.support_agent_outlined, color: Colors.greenAccent),
            onTap: () {
              showDialog(
                  context: context,
                  builder: (BuildContext context) => AlertDialog(
                        title: Text("Costumer Service"),
                        content: Text("Lanjut ke halaman CS?"),
                        actions: [
                          TextButton(
                              onPressed: () {
                                showDialog(
                                    context: context,
                                    builder: (BuildContext context) =>
                                        AlertDialog(
                                          title: Text("Coming Soon"),
                                        ));
                              },
                              child: Text("Yes")),
                          TextButton(
                              onPressed: () {
                                Navigator.pop(context, true);
                              },
                              child: Text("No"))
                        ],
                      ));
            },
          )
        ],
      ),
      extendBodyBehindAppBar: true,
      body: GoogleMap(
        mapType: MapType.hybrid,
        //zoomControlsEnabled: false,
        initialCameraPosition: _kGooglePlex,
        onMapCreated: (GoogleMapController controller) {
          _controller.complete(controller);
          BottomAppBar(
            color: Colors.white,
            child: Text("data"),
          );
        },
      ),
      // floatingActionButton: FloatingActionButton.extended(
      //   onPressed: _goToTheLake,
      //   label: Text('Zoom'),
      //   icon: Icon(Icons.zoom_in),
      // )

      floatingActionButton: new FloatingActionButton(
        onPressed: () {
          showDialog(
              context: context,
              builder: (BuildContext context) => Dialog(
                    child: Column(
                      children: [
                        SizedBox(
                          height: 20,
                        ),
                        Image(image: AssetImage('assets/icon/bar1.png')),
                        Image(image: AssetImage('assets/icon/bar2.png')),
                        Text("data")
                      ],
                    ),
                  ));
        },
        child: const Icon(Icons.menu_rounded),
        foregroundColor: Colors.grey,
        backgroundColor: Colors.white,
      ),
      floatingActionButtonLocation: FloatingActionButtonLocation.centerFloat,
      bottomNavigationBar: new BottomAppBar(
        color: Colors.white,
        //child: new Row(...),
      ),
    );
  }

  Future<void> _goToTheLake() async {
    final GoogleMapController controller = await _controller.future;
    controller.animateCamera(CameraUpdate.newCameraPosition(_kLake));
  }
}
