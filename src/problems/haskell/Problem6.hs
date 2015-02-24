sumOfSquares = sum . map (^2)

squareOfSum = (^2) . sum

solve is = (squareOfSum is) - (sumOfSquares is) 