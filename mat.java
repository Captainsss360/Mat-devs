const canvas = document.getElementById('snowCanvas');
const ctx = canvas.getContext('2d');
let dots = [];

// Kar Efekti Başlatma
function init() {
    canvas.width = window.innerWidth;
    canvas.height = window.innerHeight;
    dots = [];
    for(let i=0; i<150; i++) {
        dots.push({
            x: Math.random() * canvas.width,
            y: Math.random() * canvas.height,
            r: Math.random() * 3 + 1,
            s: Math.random() * 2 + 0.5
        });
    }
}

// Kar Çizimi
function draw() {
    ctx.clearRect(0, 0, canvas.width, canvas.height);
    ctx.fillStyle = "white";
    ctx.beginPath();
    for(let d of dots) {
        ctx.moveTo(d.x, d.y);
        ctx.arc(d.x, d.y, d.r, 0, Math.PI * 2);
    }
    ctx.fill();
    for(let d of dots) {
        d.y += d.s;
        if(d.y > canvas.height) d.y = -10;
    }
    requestAnimationFrame(draw);
}

init(); draw();
window.onresize = init;

// SAYFA GEÇİŞ FONKSİYONU (Hata Almamak İçin mat1.html Ayarlı)
function goToPage(url) {
    if (url === 'mat1.html') {
        // Geri dönerken küçülme efekti
        document.body.classList.add('pop-back');
    } else {
        // İleri giderken büyüme efekti
        document.body.classList.add('fade-out');
    }

    setTimeout(() => {
        window.location.href = url;
    }, 500);
}