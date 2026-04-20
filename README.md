# JGame
A turn-based card game built in Java, inspired by [Slay The Spire](https://store.steampowered.com/app/646570/Slay_the_Spire/) and programming themed.

## How to run
1. Make sure you have Java installed (j17+ should be fine)
2. Open the project in IntelliJ (or vsCode)
3. Run `Main.java` found in `/src/main`

Make sure the `cardAssets/`, `UIAssets/`, and `SoundEffects/` folders are in your project root, or the assets won't load.

## Gameplay
- Play cards from your hand each turn by clicking them.
- Each card costs energy, and you must have enough to play the card. The cost is shown at the top of each card. Your current energy amount is displayed under the **End Turn** button.
- Click **End Turn** to end your turn and let the enemy act, then a new hand is dealt.
- The enemies decision displays at the top right of the screen.
- Use cards that apply **Block** to avoid damage. Similarly, enemies will do the same. Current **Block** amount is displayed by each health bar and resets at the end of every turn.
- Survive through *Python* and *Sea Plus-Plus* languages to win.

## FAQ
### Why is the program not running in VSCode?!
- For some reason, sometimes I have trouble running it in VSCode, though the fix is simple.
- Press Ctrl + Shift + P
- Type "Clean Java Language Server Workspace" and press enter. Click "Reload and delete" in the bottom right color to apply the changes and the game should now work.
### How do I add new cards?
- Place art within `/cardAssets`.
- Make a static reference inside `/src/main/ArtLoader.java`.
- Duplicate a card class from `/src/Cards/CardClasses` to use as a reference.
- Replace the overridden *cardAction(Entity player, Entity enemy)* within the new class with whatever you would like the card to do.
- Initialize the card in `/src/Cards/CardInitializer.java` by replicating what's already done. Make sure to replace the parameters to correctly match the card (Name, type cost, art).
- That's it! It's now in the random pool of cards.
### Was AI used?
- AI was used to help with the [Mermaid](https://mermaid.ai/) UML diagram.

## How OOP Concepts Were Used
**Inheritance** — The game is built around inheritance . `Level1` and `Level2` both extend `BaseLevel`, sharing core level logic while overriding their own backgrounds and enemy setups. `PythonEnemyAI` and `CPlusEnemyAI` both extend `OpponentAI`, each with their own move sets and damage values. Every card (`JavaAttack`, `Parry`, `Segfault`, etc.) extends `Card` and overrides `cardAction()` to define its unique effect.

**Polymorphism** — `LevelHandler` holds a `BaseLevel` reference for `currentLevel`, meaning it can point to either `Level1` or `Level2` and call `updateLevel()` or `renderBackground()` without caring which one it is. Same idea with `OpponentAI` — the level just calls `decision()` and `opponentAction()` and the right enemy behavior runs.

**Abstraction** — `BaseLevel` defines the template for what a level needs (`init()`, `updateLevel()`, `checkEndGame()`) without implementing the details, leaving that to the subclasses. This is the same with `Card` and `cardAction()`.

## Mermaid Code
---
config:
layout: elk
---
classDiagram
direction TB
class Main {
+main(args)
}

    class GamePanel {
	    +int scaleWindow$
	    +int screenWidth$
	    +int screenHeight$
	    +int finalShrinkCards$
	    +int fps
	    +LevelHandler LevelH
	    +startGameThread()
	    +update()
	    +paintComponent(g)
    }

    class MouseListener {
	    +int mouseX
	    +int mouseY
	    +mouseReleased(e)
	    +mouseMoved(e)
    }

    class TurnHandler {
	    +boolean playerTurn
	    +Rectangle buttonBox
	    +endTurn()
	    +checkEndTurn(x, y)
	    +startEnemyTurn()
	    +endEnemyTurn()
	    +renderTurnButton(g2)
    }

    class ArtLoader {
	    +BufferedImage cardArt$
	    +BufferedImage endTurnArt$
	    +Clip attackSound$
	    +Clip shieldSound$
	    +Font perfectFont$
	    +load()$
	    +playSound(clip, volume)$
    }

    class TextRenderer {
	    +renderText(g2, text, font, color, x, y)$
    }

    class LevelHandler {
	    +TurnHandler turnH
	    +BaseLevel currentLevel
	    +Level1 Level1
	    +Level2 Level2
	    +renderLevel(g2)
    }

    class BaseLevel {
	    +Entity player
	    +Entity enemy
	    +CardHandler CH
	    +OpponentAI enemyAI
	    +int energyReplenishAmount
	    +boolean initialized
	    +boolean enemyHit
	    +init(playerStartingHealth)
	    +updateLevel(g2, turnH)
	    +checkEndGame()
	    +renderBackground(g2)
    }

    class Level1 {
	    +init(playerStartingHealth)
	    +updateLevel(g2, turnH)
	    +renderBackground(g2)
    }

    class Level2 {
	    +init(playerStartingHealth)
	    +updateLevel(g2, turnH)
	    +renderBackground(g2)
    }

    class Entity {
	    +int health
	    +int maxHealth
	    +int block
	    +int vulnerability
	    +String name
	    +HealthBar healthBar
	    +Clip hurtSound
	    +damage(incoming)
	    +addBlock(amount)
	    +setBlock(amount)
	    +applyVulnerability(amount)
	    +lowerVulnerability()
	    +renderEntityHit()
    }

    class HealthBar {
	    +Entity entity
	    +String name
	    +double widthOfBar
	    +renderHealthBar(maxHealth, health, block, g2, topLeft, shiftRight, shiftDown, font)
    }

    class OpponentAI {
	    +Entity player
	    +Entity self
	    +String decisionString
	    +String[] moves
	    +decision()
	    +opponentAction()
	    +damagePlayer(incoming)
	    +getRandomNumber(min, max)
	    +renderOpponentDecision(g2, font)
    }

    class PythonEnemyAI {
	    +int maxDamageAmount
	    +int minDamageAmount
	    +int randomDamageAmount
	    +decision()
	    +opponentAction()
	    +damagePlayer(incoming)
    }

    class CPlusEnemyAI {
	    +int maxDamageAmount
	    +int maxHealAmt
	    +int maxBlockAmt
	    +decision()
	    +opponentAction()
	    +damagePlayer(incoming)
    }

    class Card {
	    +String name
	    +String type
	    +int energyCost
	    +int value
	    +boolean Hovered
	    +BufferedImage sprite
	    +CardHandler CH
	    +drawToScreen(g2, card, x, y, cardW, cardH, CH)
	    +cardAction(player, enemy)
    }

    class CardHandler {
	    +ArrayList hand
	    +ArrayList cardBounds
	    +CardInitializer CI
	    +int energy
	    +int cardAmount
	    +int hoveredCard
	    +calculateCardX(i)
	    +calculateCardY(i)
	    +getDynamicCardWidth()
	    +getDynamicCardHeight()
	    +buildDeck()
	    +renderDeck(g2)
	    +handleCardBounds(g2)
	    +checkCardClick(mouseX, mouseY)
	    +checkCardHover(mouseX, mouseY)
    }

    class CardInitializer {
	    +ArrayList allCards
	    +randomCard()
    }

    class Attack {
	    +cardAction(player, enemy)
    }

    class JavaAttack {
	    +cardAction(player, enemy)
    }

    class Infinite {
	    +cardAction(player, enemy)
    }

    class Memory {
	    +cardAction(player, enemy)
    }

    class Firewall {
	    +cardAction(player, enemy)
    }

    class Compile {
	    +cardAction(player, enemy)
    }

    class Parry {
	    +cardAction(player, enemy)
    }

    class Ping {
	    +cardAction(player, enemy)
    }

    class Polymorphism {
	    +cardAction(player, enemy)
    }

    class Segfault {
	    +cardAction(player, enemy)
    }

    BaseLevel <|-- PythonEnemyAI
    Level2 <|-- CPlusEnemyAI
    Card <|-- Compile
    Card <|-- Ping
    Card <|-- Segfault
    Main --> GamePanel
    GamePanel --> LevelHandler
    GamePanel --> MouseListener
    LevelHandler --> TurnHandler
    LevelHandler --> BaseLevel
    LevelHandler --> Level1
    LevelHandler --> Level2
    BaseLevel --> Entity : player
    BaseLevel --> Entity : enemy
    BaseLevel --> CardHandler
    BaseLevel --> OpponentAI
    Entity --> HealthBar
    Entity --> BaseLevel : level
    CardHandler --> CardInitializer
    CardHandler --> Entity : player
    CardHandler --> Entity : enemy
    CardHandler --> TurnHandler
    MouseListener --> GamePanel
    TurnHandler --> LevelHandler
    Level1 --> PythonEnemyAI
    Level2 --> CPlusEnemyAI
    Attack -- Card
    JavaAttack -- Card
    Memory -- Card
    Infinite -- Card
    Firewall -- Card
    Parry -- Card
    Polymorphism -- Card

