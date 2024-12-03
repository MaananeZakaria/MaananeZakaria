
const canvas = document.getElementById('matrix');
const ctx = canvas.getContext('2d');

// Initialisation de la taille du canvas
canvas.width = window.innerWidth;
canvas.height = window.innerHeight;

// Caractères utilisés dans l'animation
const letters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
const fontSize = 16;
const columns = Math.floor(canvas.width / fontSize);

// Tableau représentant la position des gouttes
const drops = Array(columns).fill(1);

// Fonction de dessin de l'animation
function draw() {
  // Effacer légèrement l'écran pour créer l'effet de traînée
  ctx.fillStyle = 'rgba(0, 0, 0, 0.05)';
  ctx.fillRect(0, 0, canvas.width, canvas.height);

  // Définir le style des caractères
  ctx.fillStyle = '#0F0';
  ctx.font = `${fontSize}px monospace`;

  // Dessiner les caractères
  for (let i = 0; i < drops.length; i++) {
    const text = letters[Math.floor(Math.random() * letters.length)];
    ctx.fillText(text, i * fontSize, drops[i] * fontSize);

    // Réinitialiser les gouttes qui sortent de l'écran
    if (drops[i] * fontSize > canvas.height && Math.random() > 0.95) {
      drops[i] = 0;
    }

    drops[i]++;
  }
}

// Appeler la fonction de dessin toutes les 50ms
setInterval(draw, 50);

// Adapter le canvas lors du redimensionnement de la fenêtre
window.addEventListener('resize', () => {
  canvas.width = window.innerWidth;
  canvas.height = window.innerHeight;
  drops.length = Math.floor(canvas.width / fontSize);
  drops.fill(1);
});
