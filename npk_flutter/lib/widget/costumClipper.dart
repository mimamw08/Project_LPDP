import 'package:flutter/material.dart';
import 'package:flutter/painting.dart';

class ClipPainter extends CustomClipper<Path> {
  @override
  Path getClip(Size size) {
    var height = size.height;
    var widht = size.width;
    var path = new Path();

    path.lineTo(0, size.height);
    path.lineTo(size.width, height);
    path.lineTo(size.width, 0);

    //top corner left
    var secondControlPoint = Offset(0, 0);
    var secondEndPoint = Offset(widht * .2, height * .3);
    var offset = Offset(widht * .2, height * .2);
    path.quadraticBezierTo(secondControlPoint.dx, secondControlPoint.dy,
        secondEndPoint.dx, secondEndPoint.dy);

    //left middle
    var fifthControlPoint = Offset(widht * .3, height * .5);
    var fifthEndPoint = Offset(widht * .23, height * .6);
    path.quadraticBezierTo(fifthControlPoint.dx, fifthControlPoint.dy,
        fifthEndPoint.dx, fifthEndPoint.dy);

    //bottom left corner
    var thirdControlPoint = Offset(0, height);
    var thirdEndPoint = Offset(widht, height);
    path.quadraticBezierTo(thirdControlPoint.dx, thirdControlPoint.dy,
        thirdEndPoint.dx, thirdEndPoint.dy);

    path.lineTo(0, size.height);
    path.close();

    return path;
  }

  @override
  bool shouldReclip(CustomClipper<Path> oldClipper) {
    return true;
  }
}
