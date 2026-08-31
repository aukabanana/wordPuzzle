# 🔍 WordPuzzle Solver: The Dimensional Word Sniffer

> *"Life is too short to squint at letter grids until you go cross-eyed. Let your CPU do the heavy staring!"*

A zero-mercy **Word Find / Word Search** solver built for anyone too lazy to manually scan letter soup. Equipped with 360-degree detection and full **"Toroidal Wrap-Around"** superpowers—walk off the right edge and seamlessly reappear on the left, just like good old retro Snake!

---

## God-Tier Features

* **360° 8-Direction Radar:** Scans horizontally (left/right), vertically (up/down), and across all 45° diagonals. No neck-tilting required.
* **Donut Dimension (Toroidal Grid):** Hit a wall? No problem. Letters warp across boundaries using the mystical power of `% N`.
* **Rules Lawyer Approved:** Strictly straight lines—no illegal zigzagging, and zero cell-recycling within the same word.
* **Insanely Fast:** Computes the entire grid before your brain finishes registering the first vowel.

---

## Behind the Curtain (How It Works)

1. Scans the $N \times N$ matrix until it hits the word's first character.
2. Immediately fires directional probes across all 8 vectors.
3. Uses modular arithmetic to cleanly wrap around edges without throwing an `IndexOutOfBoundsException`:
   $$\text{next}_{\text{pos}} = (\text{current} + \text{step} + N) \pmod N$$
4. Once an unbroken chain is verified $\rightarrow$ **Boom! Logs the starting coordinate and trajectory.**

---

## Quick Start

Zero bloated dependencies. Pure, unadulterated Java.

```bash
# 1. Compile
javac wordPuzzle.java

# 2. Run and conquer
java wordPuzzle
```

---

## Sample Output
```text
--- Search Results ---
Found 'TACO' starting at (0, 0) going Right
Found 'TEAM' starting at (0, 0) going Down
Found 'NOOM' starting at (3, 3) going Left
Found 'STAR' starting at (1, 1) going Up-Right (Wrap-around!)
Word 'KUBERNETES' not found.
```
