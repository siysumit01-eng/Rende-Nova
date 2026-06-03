package com.example.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontStyle
import com.example.R
import com.example.ui.theme.Orange

@Composable
fun HomeScreen(
    onNavigateToServices: () -> Unit,
    onNavigateToLogin: () -> Unit,
    onNavigateToContact: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        TopHeader()
        
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(vertical = 16.dp)
        ) {
            Box(Modifier.padding(horizontal = 24.dp)) {
                HeroSection()
            }
            Spacer(modifier = Modifier.height(24.dp))
            Box(Modifier.padding(horizontal = 24.dp)) {
                QuickServicesGrid(onNavigateToServices = onNavigateToServices)
            }
            Spacer(modifier = Modifier.height(32.dp))
            PortfolioGallery()
            Spacer(modifier = Modifier.height(32.dp))
            TestimonialsSection()
            Spacer(modifier = Modifier.height(32.dp))
            Button(
                onClick = onNavigateToContact,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Orange),
                shape = RoundedCornerShape(16.dp),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 8.dp)
            ) {
                Icon(Icons.Default.Call, contentDescription = null, modifier = Modifier.size(20.dp))
                Spacer(modifier = Modifier.width(8.dp))
                Text("Call Us: +91 76699 75393", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            }
            Spacer(modifier = Modifier.height(64.dp)) // Extra padding for bottom nav
        }
    }
}

@Composable
fun TopHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .padding(horizontal = 24.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(MaterialTheme.colorScheme.secondary),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(20.dp)
                        .border(2.dp, MaterialTheme.colorScheme.primary)
                        .rotate(45f)
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = "Render Nova",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
        
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primaryContainer),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .size(20.dp)
                    .border(2.dp, MaterialTheme.colorScheme.onSurfaceVariant, CircleShape)
            )
        }
    }
}

@Composable
fun HeroSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(32.dp))
            .background(MaterialTheme.colorScheme.secondary)
            .padding(24.dp)
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Text(
                    text = "PROFESSIONAL SERVICES",
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.labelSmall,
                    fontWeight = FontWeight.SemiBold,
                    letterSpacing = 1.sp
                )
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.White.copy(alpha = 0.1f))
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Text(text = "⭐ 4.9", color = Color.White, fontSize = 10.sp)
                }
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Text( // We split text to enable different color styling
                text = "Crafting Your\n",
                color = Color.White,
                fontSize = 28.sp,
                lineHeight = 34.sp,
                fontWeight = FontWeight.Light
            )
            Text(
                text = "Digital Vision",
                color = MaterialTheme.colorScheme.primary,
                fontSize = 28.sp,
                lineHeight = 34.sp,
                fontWeight = FontWeight.SemiBold
            )
            
            Spacer(modifier = Modifier.height(12.dp))
            
            Text(
                text = "High-quality editing & design starting from just ₹999.",
                color = Color.White.copy(alpha = 0.7f),
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Composable
fun QuickServicesGrid(onNavigateToServices: () -> Unit) {
    val services = listOf(
        Triple("🎥", "Video Editing" to "YouTube & Reels", "₹1500"),
        Triple("📷", "Photo Editing" to "Retouch & BGR", "₹999"),
        Triple("🎨", "Graphic Design" to "Logos & Banners", "₹1600"),
        Triple("💻", "MS Projects" to "Excel & PPT", "₹1300")
    )
    
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            ServiceCardItem(services[0], 0, onNavigateToServices, Modifier.weight(1f))
            ServiceCardItem(services[1], 1, onNavigateToServices, Modifier.weight(1f))
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            ServiceCardItem(services[2], 2, onNavigateToServices, Modifier.weight(1f))
            ServiceCardItem(services[3], 3, onNavigateToServices, Modifier.weight(1f))
        }
    }
}

@Composable
fun ServiceCardItem(
    data: Triple<String, Pair<String, String>, String>,
    index: Int,
    onNavigateToServices: () -> Unit,
    modifier: Modifier = Modifier
) {
    val containerColor = when (index) {
        0 -> MaterialTheme.colorScheme.secondaryContainer
        1, 2 -> MaterialTheme.colorScheme.surfaceVariant
        else -> MaterialTheme.colorScheme.primaryContainer
    }
    val borderModifier = if (index == 1 || index == 2) {
        Modifier.border(1.dp, MaterialTheme.colorScheme.primaryContainer, RoundedCornerShape(24.dp))
    } else Modifier
    
    Column(
        modifier = modifier
            .aspectRatio(1f)
            .clip(RoundedCornerShape(24.dp))
            .then(borderModifier)
            .background(containerColor)
            .clickable { onNavigateToServices() }
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.surface),
            contentAlignment = Alignment.Center
        ) {
            Text(data.first, fontSize = 16.sp)
        }
        
        Column {
            Text(
                text = data.second.first,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = data.second.second,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = data.third,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

@Composable
fun PortfolioGallery() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "OUR WORK",
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.labelSmall,
            fontWeight = FontWeight.SemiBold,
            letterSpacing = 1.sp,
            modifier = Modifier.padding(horizontal = 24.dp)
        )
        Text(
            text = "Recent Projects",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(start = 24.dp, top = 4.dp, end = 24.dp, bottom = 16.dp)
        )
        
        LazyRow(
            contentPadding = PaddingValues(horizontal = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            val portolios = listOf(
                Pair(R.drawable.portfolio_video_edit_1780493204361, "Video Editing"),
                Pair(R.drawable.portfolio_graphic_design_1780493221953, "Graphic Design"),
                Pair(R.drawable.portfolio_photo_edit_1780493237894, "Photo Retouch")
            )
            items(portolios) { (imgRes, title) ->
                Box(
                    modifier = Modifier
                        .width(260.dp)
                        .height(180.dp)
                        .clip(RoundedCornerShape(24.dp))
                ) {
                    Image(
                        painter = painterResource(id = imgRes),
                        contentDescription = title,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                Brush.verticalGradient(
                                    colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.8f)),
                                    startY = 150f
                                )
                            )
                    )
                    Text(
                        text = title,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(16.dp)
                    )
                }
            }
        }
    }
}

data class Testimonial(val name: String, val role: String, val content: String, val rating: Int)

@Composable
fun TestimonialsSection() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "TESTIMONIALS",
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.labelSmall,
            fontWeight = FontWeight.SemiBold,
            letterSpacing = 1.sp,
            modifier = Modifier.padding(horizontal = 24.dp)
        )
        Text(
            text = "What Our Clients Say",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(start = 24.dp, top = 4.dp, end = 24.dp, bottom = 16.dp)
        )
        
        LazyRow(
            contentPadding = PaddingValues(horizontal = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            val testimonials = listOf(
                Testimonial("Priya Sharma", "Content Creator", "Render Nova completely transformed my YouTube channel. The video editing quality is unmatched and delivery is always on time!", 5),
                Testimonial("Rahul Verma", "Startup Founder", "Outstanding graphic design work. They created our complete brand identity that perfectly represents our vision.", 5),
                Testimonial("Anjali Desai", "Marketing Manager", "Professional, affordable, and incredibly talented. Have been using their photo editing services for all our campaigns.", 5)
            )
            items(testimonials) { testimonial ->
                Card(
                    modifier = Modifier.width(320.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                    shape = RoundedCornerShape(24.dp)
                ) {
                    Column(modifier = Modifier.padding(24.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            repeat(testimonial.rating) {
                                Icon(
                                    Icons.Default.Star,
                                    contentDescription = "Star",
                                    tint = com.example.ui.theme.Orange,
                                    modifier = Modifier.size(16.dp)
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = "\"${testimonial.content}\"",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            fontStyle = FontStyle.Italic
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = testimonial.name,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                        Text(
                            text = testimonial.role,
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }
        }
    }
}
